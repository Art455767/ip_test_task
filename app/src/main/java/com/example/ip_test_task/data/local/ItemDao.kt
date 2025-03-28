package com.example.ip_test_task.data.local

import android.util.Log
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ip_test_task.data.local.entities.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAllItems(): Flow<List<Item>> {
        return getAllItemsInternal()
    }

    @Query("SELECT * FROM item")
    fun getAllItemsInternal(): Flow<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)
}