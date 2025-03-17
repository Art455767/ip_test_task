package com.example.ip_test_task.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.ip_test_task.data.local.entities.Item

@Composable
fun AddItemDialog(onDismiss: () -> Unit, onSave: (Item) -> Unit) {
    var name by remember { mutableStateOf("") }
    var tags by remember { mutableStateOf("") }
    var amount by remember { mutableIntStateOf(0) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Добавить товар") },
        text = {
            Column {
                TextField(value = name, onValueChange = { name = it }, label = { Text("Название") })
                TextField(value = tags, onValueChange = { tags = it }, label = { Text("Теги") })
                TextField(
                    value = amount.toString(),
                    onValueChange = { amount = it.toIntOrNull() ?: 0 },
                    label = { Text("Количество") }
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                val newItem = Item(id = 0, name = name, time = System.currentTimeMillis(), tags = tags, amount = amount)
                onSave(newItem)
            }) {
                Text("Сохранить")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Отмена")
            }
        }
    )
}