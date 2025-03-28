package com.example.ip_test_task.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(
    @PrimaryKey val id: Int,
    val name: String,
    val time: Long,
    val tags: String,
    val amount: Int,
)