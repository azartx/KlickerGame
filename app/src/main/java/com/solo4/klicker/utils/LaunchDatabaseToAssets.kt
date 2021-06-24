package com.solo4.klicker.utils

import android.content.Context
import android.util.Log
import com.solo4.klicker.R
import com.solo4.klicker.data.Enemy
import com.solo4.klicker.data.databases.EnemiesDatabase

class LaunchDatabaseToAssets {

    private lateinit var db: EnemiesDatabase

    fun launchDb(context: Context) {

        db = EnemiesDatabase.initSecond(context)


    }

    fun getImageIntId() {
        Log.i("FFQQ", R.drawable.enemy1_1_kaban.toString())
        Log.i("FFQQ", R.drawable.enemy1_2_vosstavshi.toString())
        Log.i("FFQQ", R.drawable.enemy1_3_volf.toString())
        Log.i("FFQQ", R.drawable.enemy1_4_bolotn_zomby.toString())
        Log.i("FFQQ", R.drawable.enemy1_5_medved.toString())
        Log.i("FFQQ", R.drawable.enemy1_6_kislotnyi.toString())

        Log.i("FFQQ", "****************************")

        Log.i("FFQQ", R.drawable.enemy2_1_alpha_kaban.toString())
        Log.i("FFQQ", R.drawable.enemy2_2_mizgir.toString())
        Log.i("FFQQ", R.drawable.enemy2_3_alpha_volf.toString())
        Log.i("FFQQ", R.drawable.enemy2_4_gargylia.toString())
        Log.i("FFQQ", R.drawable.enemy2_5_alpha_medved.toString())
        Log.i("FFQQ", R.drawable.enemy2_6_traig.toString())

        Log.i("FFQQ", "****************************")

        Log.i("FFQQ", R.drawable.enemy3_1_alive_fear.toString())
        Log.i("FFQQ", R.drawable.enemy3_2_ice.toString())
        Log.i("FFQQ", R.drawable.enemy3_3_blud.toString())
    }

    fun addEasyEnemiesToDb() {

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 1,
            name = R.string.kaban_1,
            description = R.string.kaban_1_desc,
            image = R.drawable.enemy1_1_kaban,
            defaultGold = 20.0,
            attack = 10.0,
            hp = 100.0,
            critRate = 0.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 1,
            name = R.string.vosstavshi_1,
            description = R.string.vosstavshi_1_desc,
            image = R.drawable.enemy1_2_vosstavshi,
            defaultGold = 50.0,
            attack = 30.0,
            hp = 200.0,
            critRate = 60.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 1,
            name = R.string.volf_1,
            description = R.string.vosstavshi_1_desc,
            image = R.drawable.enemy1_3_volf,
            defaultGold = 100.0,
            attack = 50.0,
            hp = 300.0,
            critRate = 70.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 1,
            name = R.string.bolotn_zomby_1,
            description = R.string.bolotn_zomby_1_desc,
            image = R.drawable.enemy1_4_bolotn_zomby,
            defaultGold = 150.0,
            attack = 75.0,
            hp = 300.0,
            critRate = 60.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 1,
            name = R.string.medved_1,
            description = R.string.medved_1_desc,
            image = R.drawable.enemy1_5_medved,
            defaultGold = 200.0,
            attack = 120.0,
            hp = 500.0,
            critRate = 80.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 1,
            name = R.string.kisl_zomby_1,
            description = R.string.kisl_zomby_1_desc,
            image = R.drawable.enemy1_6_kislotnyi,
            defaultGold = 220.0,
            attack = 150.0,
            hp = 500.0,
            critRate = 85.0,
            defeat = false
        )
        )

    }

    fun addMediumEnemiesToDb() {

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 2,
            name = R.string.alfa_kaban_2,
            description = R.string.alfa_kaban_2_desc,
            image = R.drawable.enemy2_1_alpha_kaban,
            defaultGold = 500.0,
            attack = 250.0,
            hp = 600.0,
            critRate = 65.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 2,
            name = R.string.mizgir_2,
            description = R.string.mizgir_2_desc,
            image = R.drawable.enemy2_2_mizgir,
            defaultGold = 600.0,
            attack = 300.0,
            hp = 600.0,
            critRate = 70.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 2,
            name = R.string.alfa_volf_2,
            description = R.string.alfa_volf_2_desc,
            image = R.drawable.enemy2_3_alpha_volf,
            defaultGold = 800.0,
            attack = 400.0,
            hp = 700.0,
            critRate = 70.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 2,
            name = R.string.gargyliya_2,
            description = R.string.gargyliya_2_desc,
            image = R.drawable.enemy2_4_gargylia,
            defaultGold = 1000.0,
            attack = 450.0,
            hp = 1000.0,
            critRate = 70.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 2,
            name = R.string.alfa_medved_2,
            description = R.string.alfa_medved_2_desc,
            image = R.drawable.enemy2_5_alpha_medved,
            defaultGold = 1200.0,
            attack = 550.0,
            hp = 1300.0,
            critRate = 80.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 2,
            name = R.string.traig_2,
            description = R.string.traig_2_desc,
            image = R.drawable.enemy2_6_traig,
            defaultGold = 1500.0,
            attack = 700.0,
            hp = 1500.0,
            critRate = 90.0,
            defeat = false
        )
        )

    }

    fun addHardEnemiesToDb() {

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 3,
            name = R.string.alive_fear_3,
            description = R.string.alive_fear_3_desc,
            image = R.drawable.enemy3_1_alive_fear,
            defaultGold = 2000.0,
            attack = 1000.0,
            hp = 2000.0,
            critRate = 80.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 3,
            name = R.string.ice_3,
            description = R.string.ice_3_desc,
            image = R.drawable.enemy3_2_ice,
            defaultGold = 2500.0,
            attack = 3000.0,
            hp = 3500.0,
            critRate = 90.0,
            defeat = false
        )
        )

        db.getEnemiesDao().addEnemy(
            Enemy(
            level = 3,
            name = R.string.blood_solder_3,
            description = R.string.blood_solder_3_desc,
            image = R.drawable.enemy3_3_blud,
            defaultGold = 5000.0,
            attack = 5000.0,
            hp = 10000.0,
            critRate = 95.0,
            defeat = false
        )
        )

    }
    fun closeDb() {
        db.close()
    }

}