package com.solo4.klicker.data.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.solo4.klicker.data.Player

@Database(entities = [Player::class], version = 1)
abstract class PlayerDatabase : RoomDatabase() {
    abstract fun getPlayerDao(): PlayerDao

    companion object {
        fun initPlayerDb(context: Context) =
            Room.databaseBuilder(context, PlayerDatabase::class.java, "PlayerDatabase")
                .fallbackToDestructiveMigration()
                .build()
    }
}