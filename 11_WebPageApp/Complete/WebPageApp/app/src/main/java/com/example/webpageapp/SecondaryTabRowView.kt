package com.example.webpageapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryTabRowView(
  tabs: List<String>, tabIndex: Int, onTabChange: (Int) -> Unit
) {
  SecondaryScrollableTabRow(selectedTabIndex = tabIndex,
    containerColor = MaterialTheme.colorScheme.secondaryContainer
  ) {
    tabs.forEachIndexed { index, title ->
      Tab(
        selected = tabIndex == index,
        onClick = { onTabChange(index) },
        text = { Text(title) }
      )
    }

  }
}

@Preview
@Composable
fun SecondaryTabRowViewPreview() {
  SecondaryTabRowView(
    tabs = listOf("Home", "About", "Settings"),
    tabIndex = 0,
    onTabChange = { }
  )
}