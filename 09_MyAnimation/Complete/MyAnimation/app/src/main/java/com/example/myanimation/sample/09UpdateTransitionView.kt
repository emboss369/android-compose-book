package com.example.myanimation.sample

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myanimation.R

enum class BoxState {
  Small, Large
}

@Composable
fun UpdateTransitionView() {
  var currentState by remember { mutableStateOf(BoxState.Small) }
  val transition = updateTransition(targetState = currentState)

  val size by transition.animateFloat { state ->
    when (state) {
      BoxState.Small -> 0.5f
      BoxState.Large -> 1f
    }
  }
  val borderWidth by transition.animateDp { state ->
    when (state) {
      BoxState.Small -> 1.dp
      BoxState.Large -> 4.dp
    }
  }
  val color by transition.animateColor { state ->
    when (state) {
      BoxState.Small -> Color.Green
      BoxState.Large -> Color.Magenta
    }
  }

  Column(
    modifier = Modifier.size(200.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Button(onClick = {
      currentState =
        if (currentState == BoxState.Small) BoxState.Large
        else BoxState.Small
    }) {
      Text(text = "updateTransition")
    }
    Image(
      modifier = androidx.compose.ui.Modifier
        .scale(scale = size)
        .clip(shape = CircleShape)
        .border(width = borderWidth, shape = CircleShape, color = color),
      painter = painterResource(id = R.drawable.slide04),
      contentDescription = ""
    )
  }
}

@Preview(showBackground = true)
@Composable
fun UpdateTransitionViewPreview() {
  UpdateTransitionView()
}