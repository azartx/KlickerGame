package com.solo4.klicker.ui.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.solo4.klicker.data.databases.EnemiesDbRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LaunchActivityViewModel: ViewModel() {

    private var mutablyLiveData = MutableLiveData<String>()
    val liveData: LiveData<String> = mutablyLiveData

    fun launchDatabaseOneTime(context: Context) {

        CoroutineScope(Dispatchers.Main).launch {
            mutablyLiveData.value =  EnemiesDbRepository(context).initDatabaseInLaunchActivity()
        }
    }

}