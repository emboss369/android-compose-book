package com.example.webpageapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScrollableTabRowView(tabIndex: Int, onTabChange: (Int) -> Unit) {
  val tabs = listOf(
    "Home" to Icons.Default.Home,
    "About" to Icons.Default.Info,
    "Settings" to Icons.Default.Settings,
    "User" to Icons.Default.Person,
    "Nice" to Icons.Default.ThumbUp,
    "Email" to Icons.Default.Email,
    "Star" to Icons.Default.Star,
    "Menu" to Icons.Default.Menu
  )
  ScrollableTabRow(selectedTabIndex = tabIndex) {
    tabs.forEachIndexed { index, (title, icon) ->
      Tab(
        selected = tabIndex == index,
        onClick = { onTabChange(index) },
        text = { Text(title) },
        icon = { Icon(imageVector = icon, contentDescription = title) }
      )
    }
  }
}

@Preview
@Composable
fun ScrollableTabRowViewPreview() {
  var index by remember { mutableStateOf(0) }
  ScrollableTabRowView(tabIndex = index, onTabChange = { index = it })
}