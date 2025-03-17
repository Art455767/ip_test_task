package com.example.ip_test_task.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ip_test_task.data.local.entities.Item

@Composable
fun ItemCard(item: Item, onEdit: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name, fontWeight = FontWeight.Bold)
            Text(text = "Количество: ${item.amount}")
            Text(text = "Теги:")
            Row {
                item.tags.split(",").forEach { tag ->
                    Button(
                        onClick = {},
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(tag.trim())
                    }
                }
            }
            Row {
                IconButton(onClick = onEdit) {
                    Icon(Icons.Default.Edit, contentDescription = "Редактировать")
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Удалить")
                }
            }
        }
    }
}