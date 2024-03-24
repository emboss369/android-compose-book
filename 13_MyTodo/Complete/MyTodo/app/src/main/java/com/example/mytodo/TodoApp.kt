package com.example.mytodo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mytodo.ui.navigation.TodoNavHost

@Composable
fun TodoApp(
  navController: NavHostController = rememberNavController()
) {
  TodoNavHost(navController = navController)
}
