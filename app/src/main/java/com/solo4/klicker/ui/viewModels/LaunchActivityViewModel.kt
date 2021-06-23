package com.solo4.klicker.ui.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.solo4.klicker.data.EnemiesDbRepository

class LaunchActivityViewModel: ViewModel() {

    var mutablyLiveData: MutableLiveData<String> = MutableLiveData<String>()
    val liveData: LiveData<String> = mutablyLiveData

    fun launchDatabaseOneTime(context: Context) {

        EnemiesDbRepository(context).apply {
            initDatabaseInLaunchActivity()
        }
    }

}