package com.example.myanimation.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myanimation.R
import com.example.myanimation.ui.theme.MyAnimationTheme

@Composable
fun AnimatedVisibilityAutomatically() {
  var state = remember {
    MutableTransitionState(false).apply {
      targetState = true
    }
  }

  Column {
    Row(modifier = Modifier.size(width = 300.dp, height = 300.dp)) {
      AnimatedVisibility(
        visibleState = state,
        enter = scaleIn() + fadeIn(),
        exit = scaleOut() + fadeOut()
      ) {
        Image(
          painter = painterResource(id = R.drawable.slide04),
          modifier = Modifier.fillMaxSize(),
          contentDescription = ""
        )
      }
    }
    Text(
      text = when {
        state.isIdle && state.currentState -> "Visible"
        !state.isIdle && state.currentState -> "Disappearing"
        state.isIdle && !state.currentState -> "Invisible"
        else -> "Appearing"
      }
    )
    Button(onClick = { state.targetState = !state.targetState }) {
      Text("ANIMATION")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun AnimatedVisibilityAutomaticallyPreview() {
  MyAnimationTheme {
    AnimatedVisibilityAutomatically()
  }
}