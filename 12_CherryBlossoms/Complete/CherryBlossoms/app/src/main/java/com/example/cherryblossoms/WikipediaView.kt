package com.example.cherryblossoms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cherryblossoms.data.ApiSearch

@Composable
fun WikipediaView(
  viewModel: DataViewModel = viewModel(),
  onSelected: (ApiSearch) -> Unit
) {
  val cherryList = viewModel.cherryList
  LaunchedEffect(Unit) {
    viewModel.query()
  }
  if (cherryList.isEmpty()) {
    Box(
      modifier = Modifier
        .padding(64.dp)
        .fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      LinearProgressIndicator()
    }
  } else {
    WikipediaList(list = cherryList, onSelected = onSelected)
  }
}

@Preview(showBackground = true)
@Composable
fun WikipediaViewPreview() {
  WikipediaView(viewModel = DataViewModel(), onSelected = {})
}

@Preview(showBackground = true)
@Composable
fun ProgressPreview() {
  LinearProgressIndicator()
}
