package com.example.myanimation.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myanimation.R
import com.example.myanimation.ui.theme.MyAnimationTheme


@Composable
fun MultipleAnimatedVisibility() {
  var show by remember { mutableStateOf(false) }
  Column {
    Row(modifier = Modifier.size(100.dp)) {
      AnimatedVisibility(
        visible = show,
        enter = slideInHorizontally() + fadeIn(),
        exit = slideOutHorizontally() + fadeOut()
      ) {
        Image(
          painter = painterResource(id = R.drawable.slide04),
          contentDescription = null
        )
      }
    }
    Button(onClick = { show = !show }) {
      Text(text = "ANIMATION")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MultipleAnimatedVisibilityPreview() {
  MyAnimationTheme {
    MultipleAnimatedVisibility()
  }
}