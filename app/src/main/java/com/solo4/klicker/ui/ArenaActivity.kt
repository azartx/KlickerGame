package com.solo4.klicker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import com.solo4.klicker.R
import com.solo4.klicker.data.Enemy
import com.solo4.klicker.databinding.ActivityArenaBinding
import com.solo4.klicker.ui.viewModels.ArenaViewModel
import com.solo4.klicker.utils.Constants.ARENA_ENEMY_LINK

/**
 * 1. На арену в агрументы завернута ссылка на объект врага
 *    val obj: Enemy = intent.extras?.get(ARENA_ENEMY_LINK) as Enemy
 *
 * 2.
 *
 */

class ArenaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArenaBinding
    private lateinit var viewModelProvider: ViewModelProvider
    private lateinit var pickedEnemy: Enemy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArenaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getEnemy()
        showEnemy(pickedEnemy.image)
        viewModelProvider = ViewModelProvider(this)

        createAnimatedCounter() //ready? fight!

        viewModelProvider.get(ArenaViewModel::class.java).also { arenaViewModel ->
            arenaViewModel.enemyHitLiveData.observe(this, { isHited ->
                if (isHited == true) {
                    Log.i("GGFF", "got a hit")
                }
            })
            arenaViewModel.enemyHit()

        }


    }

    private fun getEnemy() {
        pickedEnemy = intent.extras?.get(ARENA_ENEMY_LINK) as Enemy
    }

    fun showEnemy(enemyImage: Int) {
        /*binding.enemyArenaImageView.apply {
            //visibility = View.INVISIBLE

            AnimationUtils.loadAnimation(context, R.anim.show_enemy_arena).start()
        }*/
        /*binding.enemyArenaImageView.setImageResource(enemyImage)
        ViewCompat.animate(binding.enemyArenaImageView)
            .setDuration(1000L)
            .alpha(1f)
            .start()*/
    }

    private fun createAnimatedCounter() {
        val counterAnimation = AnimationUtils.loadAnimation(this, R.anim.counter_animation)
        binding.animatedCounter.apply {
            text = "Ready?"
            startAnimation(counterAnimation)
        }
        counterAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?) {
                binding.animatedCounter.apply {
                    if (text == "Fight!") {
                        this.visibility = View.GONE
                        counterAnimation.setAnimationListener(null)
                    } else {
                        text = "Fight!"
                        startAnimation(counterAnimation)
                    }
                }
            }

            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}