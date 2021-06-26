package com.solo4.klicker.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solo4.klicker.data.scripts.EnemyFight
import kotlinx.coroutines.*

/**
 * @fun enemyHit запускает в многопоточке логику атаки врагов
 */

class ArenaViewModel : ViewModel() {

    private var _enemyHitLiveData = MutableLiveData<Boolean>()
    val enemyHitLiveData: LiveData<Boolean> = _enemyHitLiveData

    fun enemyHit() {
        val enemyHitJob = viewModelScope.launch {
            val enemyFightScript = EnemyFight()
            var timeBeforeEnemyHit = 5000L

            withContext(Dispatchers.Default) {
                while (true) {
                    timeBeforeEnemyHit = (timeBeforeEnemyHit * 0.93).toLong()

                    // возвращает в главный поток булевое значение, говорящее вьюхе, что была атака
                    withContext(Dispatchers.Main) {
                        _enemyHitLiveData.value = enemyFightScript.attackTimer(timeBeforeEnemyHit)
                    }

                    // время между понижениями расстояния между атаками врага
                    delay(8000L)
                    // время, при котором расстояние между тычками не уменьшается
                    if (timeBeforeEnemyHit <= 1500L) {
                        break
                    }
                }
            }
        }
    }




}

