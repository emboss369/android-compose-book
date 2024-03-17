package com.example.cherryblossoms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import com.example.cherryblossoms.data.ApiSearch
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun convertToJST(iso8601Time: String): String {
  val inputTime = ZonedDateTime.parse(iso8601Time)
  val jstTime = inputTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"))
  return jstTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))
}

@Composable
fun WikipediaRow(search: ApiSearch, onSelected: (ApiSearch) -> Unit) {
  Column(modifier = Modifier
    .fillMaxWidth()
    .background(MaterialTheme.colorScheme.secondaryContainer)
    .clickable {
      onSelected(search)
    }) {

    Text(
      text = convertToJST(search.timestamp),
      color = MaterialTheme.colorScheme.onSecondary,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.background(
        color = MaterialTheme.colorScheme.secondary
      )
    )
    Text(
      text = search.title,
      fontSize = 30.sp,
      overflow = TextOverflow.Ellipsis,
      color = MaterialTheme.colorScheme.secondary
    )
    Row(
      horizontalArrangement = Arrangement.End,
      modifier = Modifier.fillMaxWidth()
    ) {

      val snippetText = HtmlCompat.fromHtml(search.snippet, 0).toString()

      Text(
        text = snippetText,
        color = MaterialTheme.colorScheme.secondary
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun WikipediaRowPreview() {
  WikipediaRow(
    search = ApiSearch(
      ns = 0,
      title = "桜",
      pageid = 1,
      size = 1,
      wordcount = 1,
      snippet = "桜（さくら）は、バラ科サクラ属の落葉高木である。",
      timestamp = "2021-10-01T00:00:00Z"
    )
  ) {}
}