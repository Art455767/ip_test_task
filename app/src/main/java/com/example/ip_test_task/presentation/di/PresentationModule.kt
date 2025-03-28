package com.example.ip_test_task.presentation.di

import com.example.ip_test_task.domain.repositories.ItemRepository
import com.example.ip_test_task.domain.usecases.DeleteItemUseCase
import com.example.ip_test_task.domain.usecases.GetItemsUseCase
import com.example.ip_test_task.domain.usecases.InsertItemUseCase
import com.example.ip_test_task.presentation.viewmodels.ItemViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    @Singleton
    fun provideItemViewModel(
        getItemsUseCase: GetItemsUseCase,
        insertItemUseCase: InsertItemUseCase,
        deleteItemUseCase: DeleteItemUseCase,
        itemRepository: ItemRepository,
    ): ItemViewModel {
        return ItemViewModel(getItemsUseCase, insertItemUseCase, deleteItemUseCase, itemRepository)
    }
}