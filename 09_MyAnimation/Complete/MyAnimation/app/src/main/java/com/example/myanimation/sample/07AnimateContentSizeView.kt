package com.example.myanimation.sample


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
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
fun AnimateContentSizeView() {
  var flag by remember { mutableStateOf(true) }

  Column(Modifier.width(300.dp)) {
    Box(
      modifier = Modifier
        .background(Color.LightGray)
        .animateContentSize()
    ) {
      Text(
        text = if (flag) "Hello" else "Hello Compose Happy Kotlin coding"
      )
    }
    Box(
      modifier = Modifier.background(Color.LightGray)
    ) {
      Text(
        text = if (flag) "Hello" else "Hello Compose Happy Kotlin coding"
      )
    }
    Button(onClick = { flag = !flag }) {
      Text(text = "add message Compose")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun AnimateContentSizeViewPreview() {
  MyAnimationTheme {
    AnimateContentSizeView()
  }
}