package com.example.webpageapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryTabRowScreen() {
  var tabIndex by remember { mutableStateOf(0) }
  val tabs = listOf("おすすめ", "人気", "カテゴリ", "新着", "ランキング")
  var secondIndex by remember { mutableStateOf(0) }
  Scaffold(topBar = {
    Column {
      TopAppBar(title = { Text("Secondary Tab Row") })
      PrimaryTabRowView(tabIndex = tabIndex,
        onTabChange = { tabIndex = it })
    }
  }) { padding ->
    Box(
      modifier = Modifier
        .padding(padding)
        .fillMaxSize(),
      contentAlignment = Alignment.TopCenter
    ) {
      when (tabIndex) {
        0 -> {
          SecondaryTabRowView(tabs = tabs,
            tabIndex = secondIndex,
            onTabChange = { secondIndex = it })
          Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = tabs[secondIndex], fontSize = 60.sp
            )
          }
        }

        1 -> WebView(url = "https://developer.android.com")
        2 -> WebView(url = "https://www.google.com")
      }
    }
  }
}

@Preview
@Composable
fun SecondaryTabRowScreenPreview() {
  SecondaryTabRowScreen()
}