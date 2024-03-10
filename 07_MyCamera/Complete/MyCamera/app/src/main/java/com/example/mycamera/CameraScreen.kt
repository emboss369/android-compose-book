package com.example.mycamera

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CameraScreen() {
  var isGranted by remember { mutableStateOf(false) }
  val cameraState = rememberCameraState()
  PermissionHandler { granted ->
    isGranted = granted
  }

  if (isGranted) {
    Box(modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.BottomCenter) {
      PreviewCamera { ctx ->
        cameraState.startCamera(ctx)
      }
      TakePhoto(modifier = Modifier.padding(16.dp)) {
        cameraState.takePhoto()
      }
    }
  } else {
    Text(text = "カメラの権限がありません")
  }
}
