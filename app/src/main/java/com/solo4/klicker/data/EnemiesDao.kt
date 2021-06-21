package com.solo4.klicker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface EnemiesDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
fun addEnemy(enemy: Enemy)

}