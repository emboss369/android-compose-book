package com.example.myanimation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TutorialPager() {
  val imageRes = intArrayOf(
    R.drawable.tutorial0, R.drawable.tutorial1, R.drawable.tutorial2
  )
  val title = arrayOf(
    stringResource(id = R.string.tutorial_title_0),
    stringResource(id = R.string.tutorial_title_1),
    stringResource(id = R.string.tutorial_title_2),
  )
  val description = arrayOf(
    stringResource(id = R.string.tutorial_description_0),
    stringResource(id = R.string.tutorial_description_1),
    stringResource(id = R.string.tutorial_description_2),
  )
  val pagerState = rememberPagerState(pageCount = { 3 })
  val current = pagerState.currentPage
  val offset = pagerState.currentPageOffsetFraction
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.BottomCenter
  ) {
    HorizontalPager(
      state = pagerState, modifier = Modifier.fillMaxSize()
    ) { page ->
      val pageOffset =
        ((current - page) + offset).absoluteValue
      Tutorial(
        imageRes = imageRes[page],
        title = title[page],
        description = description[page],
        pageOffset = pageOffset.coerceIn(0f, 1f)
      )
    }
    DotsIndicator(
      modifier = Modifier.padding(bottom = 50.dp),
      totalDots = 3,
      selectedIndex = current,
      selectedColor = Color.White,
      unselectedColor = Color.Gray
    )
  }
}

@Preview(showBackground = true)
@Composable
fun TutorialPagerPreview() {
  TutorialPager()
}