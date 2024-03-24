package com.example.mytodo.ui.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodo.R

@Composable
fun ItemEntryBody(
  itemUiState: ItemUiState,
  onItemValueChange: (ItemDetails) -> Unit,
  onSaveClick: () -> Unit,
  showDelete: Boolean = false,
  onDeleteClick: () -> Unit = {},
  modifier: Modifier = Modifier
) {
  Column(
    verticalArrangement = Arrangement.spacedBy(
      dimensionResource(id = R.dimen.padding_large)
    ),
    modifier = modifier.padding(
      dimensionResource(id = R.dimen.padding_medium)
    )
  ) {
    ItemInputForm(
      itemDetails = itemUiState.itemDetails,
      onValueChange = onItemValueChange,
      modifier = Modifier.fillMaxWidth()
    )
    Button(
      onClick = onSaveClick,
      enabled = itemUiState.isEntryValid,
      shape = MaterialTheme.shapes.small,
      modifier = Modifier.fillMaxWidth()
    ) {
      Text(text = "保存")
    }
    if (showDelete) {
      Button(
        onClick = onDeleteClick,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults
          .buttonColors(MaterialTheme.colorScheme.error)
      ) {
        Text(text = "削除")
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ItemEntryBodyPreview() {
  ItemEntryBody(
    itemUiState = ItemUiState(),
    onItemValueChange = {},
    onSaveClick = {},
    showDelete = true
  )
}