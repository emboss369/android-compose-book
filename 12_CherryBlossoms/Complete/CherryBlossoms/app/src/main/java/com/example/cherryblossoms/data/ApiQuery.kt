package com.example.cherryblossoms.data

import kotlinx.serialization.Serializable

@Serializable
data class ApiQuery(
  val search: List<ApiSearch>
)
