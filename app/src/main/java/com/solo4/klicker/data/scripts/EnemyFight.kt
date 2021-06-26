package com.solo4.klicker.data.scripts

import kotlinx.coroutines.*

class EnemyFight {

    suspend fun attackTimer(attackRangeTime: Long) = withContext(Dispatchers.IO) {
        delay(attackRangeTime)
        return@withContext hit()
    }

    private fun hit() = true

}