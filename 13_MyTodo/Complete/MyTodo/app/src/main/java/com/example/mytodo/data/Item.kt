package com.example.mytodo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,
  val title: String,
  val description: String,
  val done: Boolean
)
