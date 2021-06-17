package com.solo4.klicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.solo4.klicker.databinding.ActivityEasyMobsBinding

class EasyMobsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEasyMobsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEasyMobsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




    }
}