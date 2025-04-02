package com.example.ip_test_task.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ip_test_task.R
import com.example.ip_test_task.data.local.entities.Item
import com.example.ip_test_task.presentation.viewmodels.ItemViewModel

@Composable
fun MainScreen(viewModel: ItemViewModel) {
    val items by viewModel.items.observeAsState(emptyList())
    var searchQuery by remember { mutableStateOf("") }
    var selectedItem by remember { mutableStateOf<Item?>(null) }
    var showEditItemDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text(stringResource(id = R.string.search_item)) },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = stringResource(id = R.string.search_item))
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(8.dp))
        )

        LazyColumn {
            items?.let {
                items(it.filter { it.name.contains(searchQuery, ignoreCase = true) }) { item ->
                    ItemCard(
                        item,
                        onEdit = {
                            selectedItem = item
                            showEditItemDialog = true
                        },
                        onDelete = {
                            selectedItem = item
                            showDeleteDialog = true
                        }
                    )
                }
            }
        }

        if (showEditItemDialog && selectedItem != null) {
            EditItemDialog(
                item = selectedItem!!,
                onDismiss = {
                    showEditItemDialog = false
                    selectedItem = null
                },
                onSave = { updatedItem ->
                    viewModel.insertItem(updatedItem)
                    showEditItemDialog = false
                    selectedItem = null
                }
            )
        }

        if (showDeleteDialog && selectedItem != null) {
            DeleteConfirmationDialog(
                onDismiss = {
                    showDeleteDialog = false
                    selectedItem = null
                },
                onDeleteConfirmed = {
                    viewModel.deleteItem(selectedItem!!)
                    showDeleteDialog = false
                    selectedItem = null
                }
            )
        }
    }
}