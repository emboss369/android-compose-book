package com.example.mytodo.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mytodo.TodoApplication
import com.example.mytodo.ui.home.HomeViewModel
import com.example.mytodo.ui.item.ItemEditViewModel
import com.example.mytodo.ui.item.ItemEntryViewModel

object AppViewModelProvider {
  val Factory = viewModelFactory {
    initializer {
      HomeViewModel(todoApplication().container.itemsRepository)
    }
    initializer {
      ItemEntryViewModel(todoApplication().container.itemsRepository)
    }
    initializer {
      ItemEditViewModel(
        this.createSavedStateHandle(),
        todoApplication().container.itemsRepository
      )
    }
  }
}

fun CreationExtras.todoApplication(): TodoApplication =
  (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
      as TodoApplication)
