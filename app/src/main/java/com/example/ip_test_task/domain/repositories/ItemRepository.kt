package com.example.ip_test_task.domain.repositories

import com.example.ip_test_task.data.local.entities.Item

interface ItemRepository {
    suspend fun getAllItems(): List<Item>
    suspend fun insertItem(item: Item)
    suspend fun deleteItem(item: Item)
    suspend fun initializeItems()
}