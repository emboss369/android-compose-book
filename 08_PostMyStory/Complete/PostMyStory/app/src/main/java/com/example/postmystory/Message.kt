package com.example.postmystory

import androidx.compose.runtime.Stable

@Stable
data class Message(
  val caption: String,
  val image: String,
  val nice: Int
)