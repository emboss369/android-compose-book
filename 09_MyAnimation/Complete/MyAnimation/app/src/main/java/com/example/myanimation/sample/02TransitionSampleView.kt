package com.example.myanimation.sample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.myanimation.R
import com.example.myanimation.ui.theme.MyAnimationTheme

@Composable
fun TransitionView(
  show: Boolean, title: String, enter: EnterTransition, exit: ExitTransition
) {
  Column() {
    Text(text = title)
    Row(
      modifier = Modifier
        .size(width = 160.dp, height = 70.dp)
        .clipToBounds()
    ) {
      AnimatedVisibility(
        visible = show, enter = enter, exit = exit
      ) {
        Image(
          painter = painterResource(id = R.drawable.slide04),
          contentDescription = ""
        )
      }
    }
  }
}

@Composable
fun TransitionGrid() {
  val animIn = listOf(
    "fadeIn" to fadeIn(),
    "slideIn" to slideIn { fullSize ->
      IntOffset(fullSize.width, fullSize.height)
    },
    "slideInHorizontally" to slideInHorizontally(),
    "slideInVertically" to slideInVertically(),
    "scaleIn" to scaleIn(),
    "expandIn" to expandIn(),
    "expandHorizontally" to expandHorizontally(),
    "expandVertically" to expandVertically()
  )
  val animOut = listOf(
    "fadeOut" to fadeOut(),
    "slideOut" to slideOut { fullSize ->
      IntOffset(fullSize.width, fullSize.height)
    },
    "slideOutHorizontally" to slideOutHorizontally(),
    "slideOutVertically" to slideOutVertically(),
    "scaleOut" to scaleOut(),
    "shrinkOut" to shrinkOut(),
    "shrinkHorizontally" to shrinkHorizontally(),
    "shrinkVertically" to shrinkVertically()
  )
  var show by remember { mutableStateOf(false) }
  Column {
    Row {
      Column {
        animIn.forEach { (title, transition) ->
          TransitionView(
            show = show,
            title = title,
            enter = transition,
            exit = ExitTransition.None
          )
        }
      }
      Column {
        animOut.forEach { (title, transition) ->
          TransitionView(
            show = !show,
            title = title,
            enter = EnterTransition.None,
            exit = transition
          )
        }
      }
    }
    Button(onClick = { show = !show }) {
      Text("ANIMATION")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun TransitionSampleViewPreview() {
  MyAnimationTheme {
    TransitionGrid()
  }
}