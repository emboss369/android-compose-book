package com.example.cherryblossoms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CherryRow(cherry: Cherry, onSelected: (Cherry) -> Unit = {}) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(MaterialTheme.colorScheme.primaryContainer)
  ) {
    Text(
      text = cherry.pref,
      color = MaterialTheme.colorScheme.onPrimary,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.background(
        color = MaterialTheme.colorScheme.primary
      )
    )
    Text(
      text = cherry.name,
      fontSize = 30.sp,
      overflow = TextOverflow.Ellipsis,
      color = MaterialTheme.colorScheme.primary
    )
    Row(horizontalArrangement = Arrangement.End,
      modifier = Modifier
        .fillMaxWidth()
        .clickable {
          onSelected(cherry)
        }) {

      Icon(imageVector = Icons.Default.LocationOn,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.clickable {
          onSelected(cherry)
        })
      Text(
        text = "${cherry.latitude}, ${cherry.longitude}",
        color = MaterialTheme.colorScheme.secondary
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun CherryRowPreview() {
  CherryRow(
    cherry = Cherry(wiki = "", name = "松前公園", pref = "北海道",
      latitude = "40.82444", longitude = "140.74")
  )
}