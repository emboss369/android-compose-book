package com.example.myslideshow

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PagerItem(
  @DrawableRes imageRes: Int,
  modifier: Modifier = Modifier
) {
  Image(
    painter = painterResource(id = imageRes),
    alignment = Alignment.Center,
    contentScale = ContentScale.Crop,
    contentDescription = null,
    modifier = modifier
  )
}

@Preview
@Composable
fun PagerItemPreview() {
  PagerItem(imageRes = R.drawable.slide00)
}