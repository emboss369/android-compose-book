package com.example.mytodo.ui.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DeleteItemDialog(onConfirm: () -> Unit, onDismiss: () -> Unit) {
  AlertDialog(onDismissRequest = onDismiss,
    title = { Text(text = "確認") },
    text = { Text(text = "このTodoアイテムを削除してもよろしいですか？") },
    confirmButton = {
      TextButton(onClick = {
        onConfirm()
      }) {
        Text(text = "削除")
      }
    },
    dismissButton = {
      TextButton(onClick = {
        onDismiss()
      }) {
        Text(text = "キャンセル")
      }
    })
}

@Preview(showBackground = true, widthDp = 400, heightDp = 300)
@Composable
fun DeleteItemDialogPreview() {
  var showDialog by remember { mutableStateOf(false) }
  var result by remember { mutableStateOf("") }
  Column {
    Button(onClick = { showDialog = true }) {
      Text(text = "Show Dialog")
    }
    if (showDialog) {
      DeleteItemDialog(onConfirm = {
        showDialog = false
        result = "confirmButtonが押されました"
      }, onDismiss = {
        showDialog = false
        result = "キャンセルされました"
      })
    }
    Text(text = result)
  }
}
