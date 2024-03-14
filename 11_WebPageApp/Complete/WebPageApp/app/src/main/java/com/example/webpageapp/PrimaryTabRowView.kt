package com.example.webpageapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTabRowView(tabIndex: Int, onTabChange: (Int) -> Unit) {

  val tabs = listOf(
    "Home" to Icons.Default.Home,
    "About" to Icons.Default.Info,
    "Settings" to Icons.Default.Settings
  )

  PrimaryTabRow(selectedTabIndex = tabIndex) {
    tabs.forEachIndexed { index, tab ->
      Tab(text = { Text(tab.first) },
        selected = tabIndex == index,
        onClick = { onTabChange(index) },
        icon = {
          Icon(
            imageVector = tab.second, contentDescription = tab.first
          )
        })
    }
  }
}

@Preview(showBackground = true)
@Composable
fun PrimaryTabRowViewPreview() {
  var index by remember { mutableStateOf(0) }
  PrimaryTabRowView(tabIndex = index, onTabChange = { index = it })
}