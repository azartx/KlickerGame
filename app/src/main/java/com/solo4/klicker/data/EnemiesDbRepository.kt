package com.solo4.klicker.data

import android.content.Context
import kotlinx.coroutines.*

class EnemiesDbRepository(val context: Context) {

    //private val mainScope = CoroutineScope(Dispatchers.Main + Job())
    private lateinit var database: EnemiesDatabase
    private val threadIO = Dispatchers.IO
    private val job = Job()

    fun initDatabase() {
        CoroutineScope(Dispatchers.IO + job).launch {
            database = EnemiesDatabase.initSecond(context)
        }
    }

    fun initDatabaseInLaunchActivity() {
        CoroutineScope(Dispatchers.Main + job).launch {
            withContext(Dispatchers.IO) {
                database = EnemiesDatabase.initSecond(context)
                closeDb()
            }
            job.join()
        }
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