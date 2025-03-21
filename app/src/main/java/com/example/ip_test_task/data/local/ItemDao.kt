package com.example.ip_test_task.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ip_test_task.data.local.entities.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    suspend fun getAllItems(): List<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)
}