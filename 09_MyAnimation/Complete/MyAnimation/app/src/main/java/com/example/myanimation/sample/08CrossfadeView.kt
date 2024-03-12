package com.example.myanimation.sample

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myanimation.R

@Composable
fun CrossfadeView() {
  var currentPage by remember { mutableStateOf("A") }
  Column() {
    Box() {
      Crossfade(targetState = currentPage) { screen ->
        when (screen) {
          "A" -> Image(
            painter = painterResource(id = R.drawable.slide04),
            contentDescription = ""
          )

          "B" -> Image(
            painter = painterResource(id = R.drawable.slide09),
            contentDescription = ""
          )
        }
      }
    }
    Button(onClick = {
      currentPage = if (currentPage == "A") "B" else "A"
    }) {
      Text(text = "currentPage: $currentPage")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun CrossfadeViewPreview() {
  CrossfadeView()
}