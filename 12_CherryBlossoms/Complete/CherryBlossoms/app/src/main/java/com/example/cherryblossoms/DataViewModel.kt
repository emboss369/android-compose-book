package com.example.cherryblossoms

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cherryblossoms.data.ApiResult
import com.example.cherryblossoms.data.ApiSearch
import fuel.Fuel
import fuel.get
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class DataViewModel : ViewModel() {
  var cherryList =  mutableStateListOf<ApiSearch>()

  fun query() {
    viewModelScope.launch {
      val string = Fuel.get(
        """
        https://ja.wikipedia.org/w/api.php?
        action=query&format=json&prop=images&list=search&formatversion=2&
        imlimit=1&srsearch=桜の名所&srlimit=500
        """.trimIndent().replace(System.lineSeparator(), "")
      ).body
      val json = Json { ignoreUnknownKeys = true }
      val result = json.decodeFromString<ApiResult>(string)
      cherryList.apply {
        clear()
        addAll(result.query.search)
      }
    }
  }
}