package com.example.ip_test_task.di

import com.example.ip_test_task.domain.repositories.ItemRepository
import com.example.ip_test_task.domain.usecases.DeleteItemUseCase
import com.example.ip_test_task.domain.usecases.GetItemsUseCase
import com.example.ip_test_task.domain.usecases.InsertItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGetItemsUseCase(itemRepository: ItemRepository): GetItemsUseCase {
        return GetItemsUseCase(itemRepository)
    }

    @Provides
    @Singleton
    fun provideInsertItemUseCase(itemRepository: ItemRepository): InsertItemUseCase {
        return InsertItemUseCase(itemRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteItemUseCase(itemRepository: ItemRepository): DeleteItemUseCase {
        return DeleteItemUseCase(itemRepository)
    }
}