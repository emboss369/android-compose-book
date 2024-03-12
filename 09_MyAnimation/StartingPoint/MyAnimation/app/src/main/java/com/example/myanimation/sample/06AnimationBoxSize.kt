package com.example.myanimation.sample

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimationBoxSize(animationSpec: AnimationSpec<Float>, text: String) {
  var size by remember { mutableStateOf(0.5f) }
  val animationScale by animateFloatAsState(
    targetValue = size, animationSpec = animationSpec
  )
  Box(
    modifier = Modifier.size(size = 300.dp), contentAlignment = Alignment.Center
  ) {
    Box(modifier = Modifier
      .scale(scale = animationScale)
      .size(size = 100.dp)
      .background(color = Color.Magenta)
      .clickable {
        size = if (size == 2f) 0.5f else 2f
      }) {
      Text(text = text)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun AnimationBoxSizePreview() {
  Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
    AnimationBoxSize(
      spring(
        dampingRatio = Spring.DampingRatioHighBouncy,
        stiffness = Spring.StiffnessMedium
      ), "ばねアニメーション"
    )
    AnimationBoxSize(
      tween(
        durationMillis = 2000,
        delayMillis = 40,
        easing = FastOutLinearInEasing
      ), "トゥイーンアニメーション"
    )
    AnimationBoxSize(
      repeatable(
        iterations = 3,
        animation = tween(durationMillis = 500),
        repeatMode = RepeatMode.Reverse
      ), "繰り返しアニメーション"
    )
    AnimationBoxSize(
      infiniteRepeatable(
        animation = tween(durationMillis = 500),
        repeatMode = RepeatMode.Reverse
      ),
      "無限繰り返しアニメーション"
    )
    AnimationBoxSize(
      keyframes {
        durationMillis = 1000
        0.0f at 0 with LinearOutSlowInEasing // for 0-750 ms
        1.5f at 750 with FastOutLinearInEasing // for 750-100 ms
        2.0f at 1000
      },
      "キーフレームアニメーション"
    )
    AnimationBoxSize(
      snap(
        delayMillis = 1000
      ),
      "スナップアニメーション"
    )
  }
}
