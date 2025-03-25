package com.example.ip_test_task.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ip_test_task.data.local.entities.Item
import com.example.ip_test_task.domain.repositories.ItemRepository
import com.example.ip_test_task.domain.usecases.DeleteItemUseCase
import com.example.ip_test_task.domain.usecases.GetItemsUseCase
import com.example.ip_test_task.domain.usecases.InsertItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val insertItemUseCase: InsertItemUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
    private val itemRepository: ItemRepository,
) : ViewModel() {

    private val _items = MutableLiveData<List<Item>?>()
    val items: MutableLiveData<List<Item>?> get() = _items

    init {
        initializeItems()
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            getItemsUseCase().collect { itemList ->
                _items.value = itemList
            }
        }
    }

    private fun initializeItems() {
        viewModelScope.launch {
            itemRepository.initializeItems()
        }
    }

    fun insertItem(item: Item) {
        viewModelScope.launch {
            insertItemUseCase(item)
            loadItems()
        }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch {
            deleteItemUseCase(item)
            loadItems()
        }
    }
}