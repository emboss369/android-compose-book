package com.example.myanimation.sample

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myanimation.ui.theme.MyAnimationTheme

@Composable
fun ChangeTwoWindow() {
  val state = remember { mutableStateOf(true) }
  val backgroundColor by animateColorAsState(
    if (state.value) Color.Blue else Color.Yellow,
    label = "color animation"
  )
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(backgroundColor)
  ) {
    Button(modifier = Modifier, onClick = { state.value = !state.value }) {
      Text("背景切り替え")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ChangeTwoWindowPreview() {
  MyAnimationTheme {
    ChangeTwoWindow()
  }
}