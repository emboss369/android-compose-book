package com.example.mytodo.data

import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
  fun getAllItemsStream(): Flow<List<Item>>
  fun getItemStream(id: Int): Flow<Item?>
  suspend fun insertItem(item: Item)
  suspend fun deleteItem(item: Item)
  suspend fun updateItem(item: Item)
}
