package com.solo4.klicker.data

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext

class EnemiesDbRepository(context: Context) {

    //private val mainScope = CoroutineScope(Dispatchers.Main + Job())
    private val database = EnemiesDatabase.initSecond(context)
    private val threadIO = Dispatchers.IO

    suspend fun getEnemiesListByLevel(enemyLevel: Int) = withContext(threadIO) {
        val list = database.getEnemiesDao().getEnemiesByLevel(enemyLevel)
        closeDb()
        return@withContext list
    }

    private fun closeDb() {
        database.close()
    }

}