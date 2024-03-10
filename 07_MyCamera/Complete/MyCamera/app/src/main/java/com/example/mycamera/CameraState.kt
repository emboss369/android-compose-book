package com.example.mycamera

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture
import java.text.SimpleDateFormat
import java.util.Locale

data class CameraState(
  val context: Context,
  val cameraProviderFuture: ListenableFuture<ProcessCameraProvider>,
  val lifecycleOwner: LifecycleOwner,
  val imageCapture: ImageCapture
) {
  fun startCamera(ctx: Context): PreviewView {
    val previewView = PreviewView(ctx).apply {
      implementationMode = PreviewView.ImplementationMode.COMPATIBLE
    }
    val executor = ContextCompat.getMainExecutor(ctx)
    cameraProviderFuture.addListener(
      {
        val cameraProvider = cameraProviderFuture.get()
        val preview = androidx.camera.core.Preview.Builder().build().also {
          it.setSurfaceProvider(previewView.surfaceProvider)
        }
        val cameraSelector =
          androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA
        try {
          cameraProvider.unbindAll()
          cameraProvider.bindToLifecycle(
            lifecycleOwner, cameraSelector, preview, imageCapture
          )
        } catch (e: Exception) {
          Log.e("CameraPreview", "Use case binding failed", e)
        }
      }, executor
    )
    return previewView
  }

  private val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
  fun takePhoto() {
    val name = SimpleDateFormat(
      FILENAME_FORMAT, Locale.US
    ).format(System.currentTimeMillis())

    val contentValues = ContentValues().apply {
      put(
        android.provider.MediaStore.MediaColumns.DISPLAY_NAME, name
      )
      put(
        android.provider.MediaStore.MediaColumns.MIME_TYPE, "image/jpeg"
      )
      put(
        android.provider.MediaStore.MediaColumns.RELATIVE_PATH,
        "Pictures/CameraX-Image"
      )
    }

    val outputOptions = ImageCapture.OutputFileOptions.Builder(
      context.contentResolver,
      android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
      contentValues
    ).build()

    imageCapture.takePicture(outputOptions,
      ContextCompat.getMainExecutor(context),
      object : ImageCapture.OnImageSavedCallback {
        override fun onError(exc: ImageCaptureException) {
          val msg = "Photo capture failed: ${exc.message}"
          Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
          Log.e("Camera", msg, exc)
        }

        override fun onImageSaved(output: ImageCapture.OutputFileResults) {
          val msg = "Photo capture succeeded: ${output.savedUri}"
          Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
          Log.d("Camera", msg)
          Intent(Intent.ACTION_SEND).also { share ->
            share.type = "image/*"
            share.putExtra(Intent.EXTRA_STREAM, output.savedUri)
            context.startActivity(
              Intent.createChooser(
                share, "Share to"
              )
            )
          }
        }
      })
  }
}

@Composable
fun rememberCameraState(
  context: Context = LocalContext.current,
  caemraProviderFuture: ListenableFuture<ProcessCameraProvider> = ProcessCameraProvider.getInstance(
    context
  ),
  lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
  imageCapture: ImageCapture = ImageCapture.Builder().build()
) = remember(context, caemraProviderFuture, lifecycleOwner) {
  CameraState(
    context = context,
    cameraProviderFuture = caemraProviderFuture,
    lifecycleOwner = lifecycleOwner,
    imageCapture = imageCapture
  )
}