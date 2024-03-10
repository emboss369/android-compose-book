package com.example.mycamera

import android.content.Context
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun PreviewCamera(createPreviewCamera: (Context) -> PreviewView) {
  AndroidView(
    factory = { ctx ->
      createPreviewCamera(ctx)
    },
  modifier = Modifier.fillMaxSize()
  )
}
