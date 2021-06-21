package com.solo4.klicker.data

import android.content.Context
import com.solo4.klicker.R

class LaunchDatabaseToAssets {

    private lateinit var db: EnemiesDatabase

    fun launchDb(context: Context) {

        db = EnemiesDatabase.init(context)


    }

    fun addEasyEnemiesToDb() {

        db.getEnemiesDao().addEnemy(Enemy(
            name = R.string.kaban_1,
            description = R.string.kaban_1_desc,
            image = R.drawable.enemy_easy_boar,
            defaultGold = 20.0,
            attack = 10.0,
            hp = 100.0,
            critRate = 0.0,
            defeat = false
        ))

        db.getEnemiesDao().addEnemy(Enemy(
            name = R.string.vosstavshi_1,
            description = R.string.vosstavshi_1_desc,
            image = R.drawable.enemy_easy_boar,
            defaultGold = 50.0,
            attack = 30.0,
            hp = 200.0,
            critRate = 60.0,
            defeat = false
        ))

        db.getEnemiesDao().addEnemy(Enemy(
            name = R.string.volf_1,
            description = R.string.vosstavshi_1_desc,
            image = R.drawable.enemy_easy_volf,
            defaultGold = 100.0,
            attack = 50.0,
            hp = 300.0,
            critRate = 70.0,
            defeat = false
        ))

        db.getEnemiesDao().addEnemy(Enemy(
            name = R.string.bolotn_zomby_1,
            description = R.string.bolotn_zomby_1_desc,
            image = R.drawable.enemy_easy_volf,
            defaultGold = 150.0,
            attack = 75.0,
            hp = 300.0,
            critRate = 60.0,
            defeat = false
        ))

        db.getEnemiesDao().addEnemy(Enemy(
            name = R.string.medved_1,
            description = R.string.medved_1_desc,
            image = R.drawable.enemy_easy_bear,
            defaultGold = 200.0,
            attack = 120.0,
            hp = 500.0,
            critRate = 80.0,
            defeat = false
        ))

        db.getEnemiesDao().addEnemy(Enemy(
            name = R.string.kisl_zomby_1,
            description = R.string.kisl_zomby_1_desc,
            image = R.drawable.enemy_easy_volf,
            defaultGold = 220.0,
            attack = 150.0,
            hp = 500.0,
            critRate = 85.0,
            defeat = false
        ))

    }

    fun addMediumEnemiesToDb() {

        db.getEnemiesDao().addEnemy(Enemy(
            name = R.string.kisl_zomby_1,
            description = R.string.kisl_zomby_1_desc,
            image = R.drawable.enemy_easy_volf,
            defaultGold = 220.0,
            attack = 150.0,
            hp = 500.0,
            critRate = 85.0,
            defeat = false
        ))

    }

}