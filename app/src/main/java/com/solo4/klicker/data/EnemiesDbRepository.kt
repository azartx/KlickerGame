package com.solo4.klicker.data

import android.content.Context
import kotlinx.coroutines.*

class EnemiesDbRepository(val context: Context) {

    //private val mainScope = CoroutineScope(Dispatchers.Main + Job())
    private lateinit var database: EnemiesDatabase
    private val threadIO = Dispatchers.IO
    private lateinit var job: Job

    fun initDatabase() {
        job = CoroutineScope(Dispatchers.IO + Job()).launch {
            database = EnemiesDatabase.initSecond(context)
        }
    }

    suspend fun initDatabaseInLaunchActivity() = withContext(Dispatchers.IO) {
        database = EnemiesDatabase.initSecond(context)
        closeDb()
        return@withContext "yes"
    }


    suspend fun getEnemiesListByLevel(enemyLevel: Int) = withContext(threadIO) {
        initDatabase()
        job.join()
        val list = database.getEnemiesDao().getEnemiesByLevel(enemyLevel)
        closeDb()
        return@withContext list
    }

    private fun closeDb() {
        database.close()
    }

}