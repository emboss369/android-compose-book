package com.example.myanimation.sample

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun AnimatableView() {
  var ok by remember { mutableStateOf(true) }
  val color = remember { Animatable(Color.Gray) }
  LaunchedEffect(ok) {
    color.animateTo(
      targetValue = if (ok) Color.Green else Color.Red,
      animationSpec = tween(durationMillis = 1000)
    )
  }
  val composableScope = rememberCoroutineScope()

  Column {
    Box(
      Modifier
        .size(300.dp)
        .background(color.value)
    ) {}
    Button(onClick = { ok = !ok }) {
      Text("ok $ok")
    }
    Button(onClick = {
      composableScope.launch {
        color.snapTo(targetValue = Color.Magenta)
      }
    }) {
      Text("snapTo")
    }
  }
}

@Preview
@Composable
fun AnimatableViewPreview() {
  AnimatableView()
}
