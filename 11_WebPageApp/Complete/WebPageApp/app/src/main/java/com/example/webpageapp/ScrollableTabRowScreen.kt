package com.example.webpageapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScrollableTabRowScreen() {
  var tabIndex by remember { mutableStateOf(0) }
  Scaffold(bottomBar = {
    ScrollableTabRowView(tabIndex = tabIndex,
      onTabChange = { tabIndex = it })
  }) { padding ->
    Box(
      modifier = Modifier
        .padding(padding)
        .fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = "Tab $tabIndex",
        modifier = Modifier.padding(16.dp),
        fontSize = 60.sp
      )
    }
  }
}

@Preview
@Composable
fun ScrollableTabRowScreenPreview() {
  ScrollableTabRowScreen()
}