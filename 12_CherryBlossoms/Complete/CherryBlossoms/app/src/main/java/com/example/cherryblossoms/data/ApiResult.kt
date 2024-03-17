package com.example.cherryblossoms.data

import kotlinx.serialization.Serializable

@Serializable
data class ApiResult(
  val query: ApiQuery
)