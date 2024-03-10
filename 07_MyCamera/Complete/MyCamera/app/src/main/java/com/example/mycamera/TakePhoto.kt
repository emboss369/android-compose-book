package com.example.mycamera

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TakePhoto(modifier: Modifier = Modifier, takePhoto: () -> Unit ) {
  Button(
    onClick = {
      takePhoto()
    },
    modifier = modifier.size(90.dp),
    colors = ButtonDefaults.buttonColors(
      containerColor = Color.White, contentColor = Color.Red
    )
  ) {
    Text(text = "●", fontSize = 30.sp)
  }
}

@Preview(showBackground = true)
@Composable
fun TakePhotoPreview() {
  TakePhoto(takePhoto = {})
}
