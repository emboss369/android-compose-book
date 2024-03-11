package com.example.postmystory

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen(messages: MutableList<Message>, onClick: () -> Unit) {
  val state = rememberLazyListState()
  Box {
    LazyColumn(state = state) {
      items(items = messages) { message ->
        ArticleView(message = message)
      }
    }
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.BottomEnd
    ) {
      FloatingActionButton(
        onClick = onClick,
        modifier = Modifier.padding(16.dp)
      ) {
        Icon(
          imageVector = Icons.Default.Add,
          contentDescription = null
        )
      }
    }
  }
}

@Preview
@Composable
fun ListScreenPreview() {
  val messages = mutableListOf<Message>().apply {
    for (i in 1..24) {
      add(
        Message(
          image = "https://picsum.photos/seed/$i/200",
          caption = "Caption $i",
          nice = i
        )
      )
    }
  }
  ListScreen(messages = messages, onClick = { })
}