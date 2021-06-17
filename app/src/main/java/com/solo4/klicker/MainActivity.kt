package com.solo4.klicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.solo4.klicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.easyButton.setOnClickListener {
            Toast.makeText(applicationContext, "EASY", Toast.LENGTH_LONG).show()
        }

        binding.mediumButton.setOnClickListener {
            Toast.makeText(applicationContext, "MEDIUM", Toast.LENGTH_LONG).show()
        }

        binding.hardButton.setOnClickListener {
            Toast.makeText(applicationContext, "HARD", Toast.LENGTH_LONG).show()
        }

    }



}