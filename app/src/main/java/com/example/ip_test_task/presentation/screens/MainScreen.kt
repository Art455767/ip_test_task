package com.example.ip_test_task.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import com.example.ip_test_task.data.local.entities.Item
import com.example.ip_test_task.presentation.viewmodels.ItemViewModel
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun MainScreen(viewModel: ItemViewModel) {
    val items by viewModel.items.observeAsState(emptyList())
    var searchQuery by remember { mutableStateOf("") }
    var selectedItem by remember { mutableStateOf<Item?>(null) }

    Column {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Поиск товара") },
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn {
            items?.let { it ->
                items(it.filter { it.name.contains(searchQuery, ignoreCase = true) }) { item ->
                    ItemCard(item, onEdit = { selectedItem = item }, onDelete = { viewModel.deleteItem(item) })
                }
            }
        }

        selectedItem?.let {
            EditItemDialog(item = it, onDismiss = { selectedItem = null }, onSave = { updatedItem ->
                viewModel.insertItem(updatedItem)
                selectedItem = null
            })
        }
    }
}