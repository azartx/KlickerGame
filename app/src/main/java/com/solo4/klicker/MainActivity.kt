package com.solo4.klicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.solo4.klicker.Constants.ENEMY_EASY
import com.solo4.klicker.Constants.ENEMY_HARD
import com.solo4.klicker.Constants.ENEMY_MEDIUM
import com.solo4.klicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.easyButton.setOnClickListener {
            openFragment(ENEMY_EASY)
        }

        binding.mediumButton.setOnClickListener {
            openFragment(ENEMY_MEDIUM)
        }

        binding.hardButton.setOnClickListener {
            openFragment(ENEMY_HARD)
        }

    }

    private fun openFragment(enemyComplexity: Int) {
        when (enemyComplexity) {
            ENEMY_EASY -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.mobsFragmentContainer, EasyMobsFragment::class.java, null)
                    .addToBackStack("")
                    .commit()
            }

            ENEMY_MEDIUM -> {
                Toast.makeText(applicationContext, "MEDIUM", Toast.LENGTH_LONG).show()
            }

            ENEMY_HARD -> {
                Toast.makeText(applicationContext, "HARD", Toast.LENGTH_LONG).show()
            }
        }
    }

}