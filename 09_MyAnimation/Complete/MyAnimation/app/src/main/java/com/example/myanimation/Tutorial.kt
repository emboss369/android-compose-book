package com.example.myanimation

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Tutorial(
  modifier: Modifier = Modifier,
  @DrawableRes imageRes: Int,
  title: String,
  description: String,
  pageOffset: Float = 0f
) {
  val alpha by animateFloatAsState(1f - pageOffset)
  val offset by animateDpAsState((pageOffset * 100).dp)
  Box(
    modifier = modifier.fillMaxSize()
  ) {
    Image(
      painter = painterResource(id = imageRes),
      contentScale = ContentScale.Crop,
      contentDescription = description
    )
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(50.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Spacer(modifier = Modifier.size(60.dp))
      Text(
        modifier = Modifier.offset(y = offset * 3),
        text = title,
        fontFamily = FontFamily.Cursive,
        fontSize = 60.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White.copy(alpha = alpha),
        lineHeight = 50.sp,
        style = TextStyle(
          shadow = Shadow(
            color = Color.Black, blurRadius = 5f, offset = Offset(10f, 10f)
          )
        )
      )
      Spacer(modifier = Modifier.size(30.dp))
      Text(
        modifier = Modifier.offset(x = offset * 3),
        text = description,
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White.copy(alpha = alpha),
        lineHeight = 40.sp,
        style = TextStyle(
          shadow = Shadow(
            color = Color.Black, blurRadius = 2f, offset = Offset(4f, 4f)
          )
        )
      )
    }
  }
}

@Preview
@Composable
fun TutorialPreview() {
  Tutorial(
    imageRes = R.drawable.tutorial0,
    title = "Lorem ipsum dolor sit amet,",
    description = "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    pageOffset = 0f
  )
}