package com.example.cherryblossoms

import kotlinx.serialization.Serializable

@Serializable
data class Cherry(
  val wiki: String,
  val name: String,
  val pref: String,
  val longitude: String,
  val latitude: String
)
