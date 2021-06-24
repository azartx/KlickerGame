package com.solo4.klicker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @ColumnInfo var name: String,
    @ColumnInfo var hp: Double,
    @ColumnInfo var armor: Double,
    @ColumnInfo var damage: Double,
    @ColumnInfo var criticalRate: Double
) {
    @ColumnInfo @PrimaryKey(autoGenerate = true)
    var id = 0
    /*@ColumnInfo var gun: Gun? = null
    @ColumnInfo var shield: Shield? = null
    @ColumnInfo var equipment: Equipment? = null*/
}
