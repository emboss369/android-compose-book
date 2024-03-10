package com.example.mycamera


import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
fun PermissionHandler(onGranted: (Boolean) -> Unit) {
  val launcher = rememberLauncherForActivityResult(
    ActivityResultContracts.RequestPermission()
  ) { granted ->
    onGranted(granted)
  }
  val context = LocalContext.current
  if (ContextCompat.checkSelfPermission(
      context, android.Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED
  ) {
    onGranted(true)
  } else {
    SideEffect {
      launcher.launch(android.Manifest.permission.CAMERA)
    }
  }
}
