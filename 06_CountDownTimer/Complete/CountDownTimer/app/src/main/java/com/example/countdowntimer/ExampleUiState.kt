package com.example.countdowntimer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class ExampleUiState(
  var time: MutableState<Long> = mutableStateOf(3 * 60 * 1000),
  var timeLeft: MutableState<Long> = mutableStateOf(time.value),
  var isRunning: MutableState<Boolean> = mutableStateOf(false)
)
