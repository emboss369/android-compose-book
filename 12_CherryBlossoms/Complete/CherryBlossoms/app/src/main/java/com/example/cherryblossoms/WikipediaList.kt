package com.example.cherryblossoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cherryblossoms.data.ApiSearch

@Composable
fun WikipediaList(list: List<ApiSearch>?, onSelected: (ApiSearch) -> Unit) {
  LazyColumn(
    verticalArrangement = Arrangement.spacedBy(16.dp),
    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
  ) {
    list?.let {
      items(list.size) { index ->
        WikipediaRow(search = list[index], onSelected = onSelected)
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun WikipediaListPreview() {
  val list = listOf(
    ApiSearch(
      ns = 0,
      title = "桜",
      pageid = 1,
      size = 1,
      wordcount = 1,
      snippet = "桜（さくら）は、バラ科サクラ属の落葉高木である。",
      timestamp = "2021-10-01T00:00:00Z"
    ),
    ApiSearch(
      ns = 0,
      title = "title2",
      pageid = 2,
      size = 2,
      wordcount = 2,
      snippet = "snippet2",
      timestamp = "2021-10-02T00:00:00Z"
    ),
    ApiSearch(
      ns = 0,
      title = "title3",
      pageid = 3,
      size = 3,
      wordcount = 3,
      snippet = "snippet3",
      timestamp = "2021-10-03T00:00:00Z"
    )
  )
  WikipediaList(list = list, onSelected = {})
}