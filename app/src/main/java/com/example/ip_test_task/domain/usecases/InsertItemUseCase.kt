package com.example.ip_test_task.domain.usecases

import com.example.ip_test_task.data.local.entities.Item
import com.example.ip_test_task.domain.repositories.ItemRepository

class InsertItemUseCase(private val itemRepository: ItemRepository) {
    suspend operator fun invoke(item: Item) {
        itemRepository.insertItem(item)
    }
}