package com.example.ip_test_task.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import com.example.ip_test_task.data.local.entities.Item

@Composable
fun EditItemDialog(item: Item, onDismiss: () -> Unit, onSave: (Item) -> Unit) {
    var amount by remember { mutableIntStateOf(item.amount) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Редактировать товар") },
        text = {
            Column {
                Text(text = "Название: ${item.name}")
                TextField(
                    value = amount.toString(),
                    onValueChange = { newValue ->
                        amount = newValue.toIntOrNull() ?: 0
                    },
                    label = { Text("Количество") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onSave(item.copy(amount = amount))
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