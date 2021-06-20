package com.solo4.klicker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.solo4.klicker.data.Enemy
import com.solo4.klicker.databinding.ActivityArenaBinding
import com.solo4.klicker.utils.Constants.ARENA_ENEMY_LINK

class ArenaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArenaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArenaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val obj: Enemy = intent.extras?.get(ARENA_ENEMY_LINK) as Enemy

        binding.testText.text = obj.description

    }
}