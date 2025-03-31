package com.example.ip_test_task.data.di

import android.content.Context
import com.example.ip_test_task.data.local.AppDatabase
import com.example.ip_test_task.data.local.ItemDao
import com.example.ip_test_task.data.repositories.ItemRepositoryImpl
import com.example.ip_test_task.domain.repositories.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideItemDao(database: AppDatabase): ItemDao {
        return database.itemDao()
    }

    @Provides
    @Singleton
    fun provideItemRepository(itemDao: ItemDao): ItemRepository {
        return ItemRepositoryImpl(itemDao)
    }
}