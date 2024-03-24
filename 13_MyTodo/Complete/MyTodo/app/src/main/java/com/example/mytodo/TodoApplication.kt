package com.example.mytodo

import android.app.Application
import com.example.mytodo.data.AppContainer
import com.example.mytodo.data.AppDataContainer

class TodoApplication : Application() {
  lateinit var container: AppContainer
  override fun onCreate() {
    super.onCreate()
    container = AppDataContainer(this)
  }
}