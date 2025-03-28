package com.example.ip_test_task.data.repositories

import com.example.ip_test_task.data.local.ItemDao
import com.example.ip_test_task.data.local.entities.Item
import com.example.ip_test_task.domain.repositories.ItemRepository
import kotlinx.coroutines.flow.Flow

class ItemRepositoryImpl(private val itemDao: ItemDao) : ItemRepository {
    override suspend fun getAllItems(): Flow<List<Item>> {
        return itemDao.getAllItems()
    }

    override suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item)
    }
}
