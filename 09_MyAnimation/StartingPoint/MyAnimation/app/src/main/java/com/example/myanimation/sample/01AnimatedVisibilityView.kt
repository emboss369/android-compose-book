package com.example.myanimation.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myanimation.ui.theme.MyAnimationTheme

@Composable
fun AnimatedVisibilityView() {
  var show by remember { mutableStateOf(true) }
  Box {
    Column {
      AnimatedVisibility(visible = show) {
        Text(modifier = Modifier.size(size = 100.dp)
          .background(color = Color.Magenta),
          text = "アニメーションします")
      }
      Button(onClick = { show = !show }) {
        Text(if (show) "表示" else "非表示")
      }
    }
  }
}

@Preview(widthDp = 100, heightDp = 150, showBackground = true)
@Composable
fun AnimatedVisibilityViewPreview() {
  MyAnimationTheme {
    AnimatedVisibilityView()
  }
}