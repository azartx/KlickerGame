package com.solo4.klicker.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.solo4.klicker.R
import com.solo4.klicker.ui.viewModels.LaunchActivityViewModel

class LaunchScreenActivity : AppCompatActivity() {

    private lateinit var viewModelProvider: ViewModelProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)

        viewModelProvider = ViewModelProvider(this)
        viewModelProvider.get(LaunchActivityViewModel::class.java).also { viewModel ->
            viewModel.liveData.observe(this, { callback ->
                if (callback == "yes") {
                    startMainActivity()
                }
            })
            viewModel.launchDatabaseOneTime(applicationContext)
        }


    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}