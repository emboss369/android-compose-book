package com.example.order

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MainScreen() {
  var isOrderView by remember { mutableStateOf(false) }
  if (isOrderView) {
    OrderView(onTapButton = { isOrderView = false })
  } else {
    TopView(onTapButton = { isOrderView = true })
  }
}