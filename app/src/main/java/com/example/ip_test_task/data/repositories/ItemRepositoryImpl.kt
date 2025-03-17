package com.example.ip_test_task.data.repositories

import com.example.ip_test_task.data.local.ItemDao
import com.example.ip_test_task.data.local.entities.Item
import com.example.ip_test_task.domain.repositories.ItemRepository

class ItemRepositoryImpl(private val itemDao: ItemDao) : ItemRepository {
    override suspend fun getAllItems(): List<Item> {
        return itemDao.getAllItems()
    }

    override suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item)
    }

    override suspend fun initializeItems() {
        val existingItems = getAllItems()
        if (existingItems.isEmpty()) {
            val itemsToInsert = listOf(
                Item(
                    id = 1, name = "Amazon Kindle Paperwhite", time = System.currentTimeMillis(),
                    tags = "Электронная книга, Последний шанс, Ограниченный", amount = 5
                ),
                Item(
                    id = 2,
                    name = "LG OLED TV",
                    time = System.currentTimeMillis(),
                    tags = "Телевизор, Эксклюзив, Ограниченный",
                    amount = 3
                ),
                Item(
                    id = 3,
                    name = "iPhone 13",
                    time = System.currentTimeMillis(),
                    tags = "Телефон, Новый, Распродажа",
                    amount = 10
                ),
                Item(
                    id = 4,
                    name = "Apple Watch Series 7",
                    time = System.currentTimeMillis(),
                    tags = "Часы, Новый, Рекомендуем",
                    amount = 7
                ),
                Item(
                    id = 5,
                    name = "GoPro Hero 10",
                    time = System.currentTimeMillis(),
                    tags = "Камера, Эксклюзив",
                    amount = 2
                ),
                Item(id = 6, name = "Fitbit Charge 5", time = System.currentTimeMillis(), tags = "", amount = 4),
                Item(
                    id = 7,
                    name = "MacBook Air M1",
                    time = System.currentTimeMillis(),
                    tags = "Ноутбук, Тренд",
                    amount = 6
                ),
                Item(
                    id = 8,
                    name = "Xiaomi Mi 11",
                    time = System.currentTimeMillis(),
                    tags = "Телефон, Скидка, Распродажа",
                    amount = 8
                ),
                Item(
                    id = 9,
                    name = "PlayStation 5",
                    time = System.currentTimeMillis(),
                    tags = "Игровая приставка, Акция, Распродажа",
                    amount = 1
                ),
                Item(
                    id = 10,
                    name = "Samsung Galaxy S21",
                    time = System.currentTimeMillis(),
                    tags = "Телефон, Хит",
                    amount = 5
                )
            )
            itemsToInsert.forEach { insertItem(it) }
        }
    }
}
