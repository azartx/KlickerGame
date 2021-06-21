package com.solo4.klicker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EnemiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addEnemy(enemy: Enemy)

    @Query("SELECT * from Enemy WHERE level = :level")
    fun getEnemiesByLevel(level: Int): List<Enemy>

}