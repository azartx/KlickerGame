package com.solo4.klicker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.solo4.klicker.R
import com.solo4.klicker.utils.Constants.ENEMY_EASY
import com.solo4.klicker.utils.Constants.ENEMY_HARD
import com.solo4.klicker.utils.Constants.ENEMY_MEDIUM
import com.solo4.klicker.databinding.ActivityMainBinding
import com.solo4.klicker.utils.Constants.ENEMY_EASY_PREVIEW_FRAGMENT
import com.solo4.klicker.utils.Constants.ENEMY_EASY_STR
import com.solo4.klicker.utils.Constants.ENEMY_HARD_PREVIEW_FRAGMENT
import com.solo4.klicker.utils.Constants.ENEMY_HARD_STR
import com.solo4.klicker.utils.Constants.ENEMY_MEDIUM_PREVIEW_FRAGMENT
import com.solo4.klicker.utils.Constants.ENEMY_MEDIUM_STR

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*LaunchDatabaseToAssets().apply {
            launchDb(applicationContext)
            addEasyEnemiesToDb()
            addMediumEnemiesToDb()
            addHardEnemiesToDb()
            closeDb()
        }*/


        binding.easyButton.setOnClickListener {
            Bundle().run {
                putInt(ENEMY_EASY_STR, ENEMY_EASY)
                openFragment(ENEMY_EASY, this)
            }


        }

        binding.mediumButton.setOnClickListener {
            Bundle().run {
                putInt(ENEMY_MEDIUM_STR, ENEMY_MEDIUM)
                openFragment(ENEMY_MEDIUM, this)
            }

        }

        binding.hardButton.setOnClickListener {
            Bundle().run {
                putInt(ENEMY_HARD_STR, ENEMY_HARD)
                openFragment(ENEMY_HARD, this)
            }
        }

        /*LaunchDatabaseToAssets().run {
            launchDb(applicationContext)
            addEasyEnemiesToDb()
            addMediumEnemiesToDb()
            addHardEnemiesToDb()
            closeDb()
        }*/

    }

    private fun openFragment(enemyComplexity: Int, bundle: Bundle?) {
        when (enemyComplexity) {
            ENEMY_EASY -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.mobsFragmentContainer, EasyMobsFragment::class.java, bundle)
                    .addToBackStack(ENEMY_EASY_PREVIEW_FRAGMENT)
                    .commit()
            }

            ENEMY_MEDIUM -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.mobsFragmentContainer, EasyMobsFragment::class.java, bundle)
                    .addToBackStack(ENEMY_MEDIUM_PREVIEW_FRAGMENT)
                    .commit()
            }

            ENEMY_HARD -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.mobsFragmentContainer, EasyMobsFragment::class.java, bundle)
                    .addToBackStack(ENEMY_HARD_PREVIEW_FRAGMENT)
                    .commit()
            }
        }
    }

}