package com.example.webpageapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TabRowScreen() {
  var tabIndex by remember { mutableStateOf(0) }
  Scaffold(bottomBar = {
    BottomAppBar {
      TabRowView(tabIndex = tabIndex, onTabChange = { tabIndex = it })
    }
  }) { padding ->
    Box(
      modifier = Modifier
        .padding(padding)
        .fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      when (tabIndex) {
        0 -> Text("Home Tab")
        1 -> WebView(url = "https://developer.android.com")
        2 -> WebView(url = "https://www.google.com")
      }
    }
  }
}

@Preview
@Composable
fun TabRowScreenPreview() {
  TabRowScreen()
}