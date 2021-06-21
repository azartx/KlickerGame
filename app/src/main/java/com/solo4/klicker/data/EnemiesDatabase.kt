package com.solo4.klicker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Enemy::class], version = 1)
abstract class EnemiesDatabase : RoomDatabase() {
    abstract fun getEnemiesDao(): EnemiesDao

    companion object {
        fun init(context: Context) =
            Room.databaseBuilder(context, EnemiesDatabase::class.java, "EnemiesDatabase")
                .createFromAsset("databases/EnemiesDatabase.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()

    }
}