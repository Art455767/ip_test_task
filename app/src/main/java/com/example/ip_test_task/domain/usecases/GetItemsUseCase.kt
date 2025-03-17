package com.example.ip_test_task.domain.usecases

import com.example.ip_test_task.data.local.entities.Item
import com.example.ip_test_task.domain.repositories.ItemRepository

class GetItemsUseCase(private val itemRepository: ItemRepository) {
    suspend operator fun invoke(): List<Item>? {
        return itemRepository.getAllItems()
    }
}