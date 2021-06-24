package com.solo4.klicker.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArenaViewModel : ViewModel() {

    private var _liveData = MutableLiveData<Any>()
    val liveData: LiveData<Any> = _liveData

    fun doSmth() {

    }

}