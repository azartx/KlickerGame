package com.solo4.klicker.ui

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.solo4.klicker.R
import com.solo4.klicker.databinding.ActivityArenaBinding
import java.util.*

/**
 * 1. На арену в агрументы завернута ссылка на объект врага
 *    val obj: Enemy = intent.extras?.get(ARENA_ENEMY_LINK) as Enemy
 *
 * 2.
 *
 */

class ArenaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArenaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArenaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        createAnimatedCounter()

    }

    private fun createAnimatedCounter() {
        val counterAnimation = AnimationUtils.loadAnimation(this, R.anim.counter_animation)

        binding.animatedCounter.apply {
            text = "Ready?"
            startAnimation(counterAnimation)
        }

        counterAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.animatedCounter.apply {
                    if (text == "Fight!") {
                        this.visibility = View.GONE
                    } else {
                        text = "Fight!"
                        startAnimation(counterAnimation)
                    }


                }
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
    }
}