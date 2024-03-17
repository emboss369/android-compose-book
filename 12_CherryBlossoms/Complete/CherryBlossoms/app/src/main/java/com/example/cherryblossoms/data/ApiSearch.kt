package com.example.cherryblossoms.data

import kotlinx.serialization.Serializable

@Serializable
data class ApiSearch(
  val ns: Int,
  val title: String,
  val pageid: Int,
  val size: Int,
  val wordcount: Int,
  val snippet: String,
  val timestamp: String
)