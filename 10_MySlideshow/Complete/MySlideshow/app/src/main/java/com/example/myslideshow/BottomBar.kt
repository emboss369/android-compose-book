package com.example.myslideshow

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FirstPage
import androidx.compose.material.icons.filled.LastPage
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBar(
  pagerState: PagerState
) {
  val scope = rememberCoroutineScope()
  BottomAppBar {
    Row(
      horizontalArrangement = Arrangement.Center,
      modifier = Modifier.fillMaxWidth()
    ) {
      IconButton(
        onClick = {
          scope.launch {
            pagerState.animateScrollToPage(0)
          }
        }, enabled = pagerState.currentPage > 0
      ) {
        Icon(
          imageVector = Icons.Default.FirstPage, contentDescription = null
        )
      }
      IconButton(
        onClick = {
          scope.launch {
            pagerState.animateScrollToPage(pagerState.currentPage - 1)
          }
        }, enabled = pagerState.currentPage > 0
      ) {
        Icon(
          imageVector = Icons.Default.NavigateBefore,
          contentDescription = null
        )
      }
      IconButton(
        onClick = {
          scope.launch {
            pagerState.animateScrollToPage(pagerState.currentPage + 1)
          }
        }, enabled = pagerState.currentPage < pagerState.pageCount - 1
      ) {
        Icon(
          imageVector = Icons.Default.NavigateNext,
          contentDescription = null
        )
      }
      IconButton(
        onClick = {
          scope.launch {
            pagerState.animateScrollToPage(pagerState.pageCount - 1)
          }
        }, enabled = pagerState.currentPage < pagerState.pageCount - 1
      ) {
        Icon(
          imageVector = Icons.Default.LastPage, contentDescription = null
        )
      }
    }
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun BottomBarPreview() {
  val pagerState = rememberPagerState { 3 }
  BottomBar(pagerState = pagerState)
}