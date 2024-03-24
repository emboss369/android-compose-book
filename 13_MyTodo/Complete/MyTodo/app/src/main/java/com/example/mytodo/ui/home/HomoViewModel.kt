package com.example.mytodo.ui.home

import androidx.lifecycle.ViewModel
import com.example.mytodo.data.Item
import com.example.mytodo.data.ItemsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HomeUiState(val itemList: Flow<List<Item>> = flowOf(listOf()))

class HomeViewModel(itemsRepository: ItemsRepository) : ViewModel() {
  open val homeUiState = HomeUiState(itemsRepository.getAllItemsStream())
}
