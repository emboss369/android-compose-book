package com.example.mytodo.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodo.data.ItemsRepository
import kotlinx.coroutines.launch

class ItemEditViewModel(
  savedStateHandle: SavedStateHandle,
  private val itemsRepository: ItemsRepository
) : ViewModel() {
  var itemUiState by mutableStateOf(ItemUiState())
    private set

  private val itemId: Int =
    checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

  init {
    viewModelScope.launch {
      itemsRepository.getItemStream(itemId).collect { item ->
        item?.let {
          itemUiState = it.toItemUiState(true)
        }
      }
    }
  }

  suspend fun updateItem() {
    if (validateInput(itemUiState.itemDetails)) {
      itemsRepository.updateItem(itemUiState.itemDetails.toItem())
    }
  }

  suspend fun deleteItem() {
    itemsRepository.deleteItem(itemUiState.itemDetails.toItem())
  }

  fun updateUiState(itemDetails: ItemDetails) {
    itemUiState =
      ItemUiState(
        itemDetails = itemDetails,
        isEntryValid = validateInput(itemDetails)
      )
  }

  private fun validateInput(
    uiState: ItemDetails = itemUiState.itemDetails
  ): Boolean {
    return with(uiState) {
      title.isNotBlank() && description.isNotBlank()
    }
  }
}