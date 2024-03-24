package com.example.mytodo.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodo.R
import com.example.mytodo.data.Item


@Composable
fun HomeBody(
  itemList: List<Item>,
  onItemClick: (Item) -> Unit = {},
  onCheckedChange: (Boolean) -> Unit = {},
  modifier: Modifier = Modifier
) {
  var checked by remember { mutableStateOf(false) }
  LazyColumn(modifier = modifier) {
    item {
      Row(
        Modifier.toggleable(value = checked,
          role = Role.Checkbox,
          onValueChange = {
            checked = it
            onCheckedChange(it)
          })
      ) {
        Checkbox(
          checked = checked, onCheckedChange = null
        )
        Text(text = "完了したTodoも表示する")
      }
    }
    if (itemList.isEmpty()) {
      item {
        Text(
          text = "Todoアイテムがないようです。Todo追加をタップしてください。",
          textAlign = TextAlign.Center,
          style = MaterialTheme.typography.titleLarge
        )
      }
    }
    items(items = itemList, key = { it.id }) { item ->
      TodoItem(item = item,
        modifier = Modifier
          .padding(dimensionResource(id = R.dimen.padding_small))
          .clickable { onItemClick(item) })
    }
  }
}

@Preview(showBackground = true)
@Composable
fun HomeBodyPreview() {
  HomeBody(
    itemList = listOf(
      Item(1, "タイトル", "詳細", true),
      Item(2, "タイトル", "詳細", false)
    )
  )
}