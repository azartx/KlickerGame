package com.solo4.klicker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Enemy(
    @ColumnInfo var name: String,
    @ColumnInfo var description: String,
    @ColumnInfo var image: Int,
    @ColumnInfo var defaultGold: Double,
    @ColumnInfo var attack: Double,
    @ColumnInfo var armor: Double,
) {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}