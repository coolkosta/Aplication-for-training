package com.coolkosta.aplicationfortraning

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.parcelize.Parcelize

class MainActivityViewModel : ViewModel() {

    val stateLiveData: LiveData<State> get() = _stateLiveData
    private val _stateLiveData = MutableLiveData<State>()

    fun initState(state: State) {
        _stateLiveData.value = state
    }

    fun tapped() {
        val oldState = _stateLiveData.value?.count?.plus(1)
        _stateLiveData.value = State(count = oldState!!, text = "U tapped $oldState times" )
    }


    @Parcelize
    data class State(var count: Int, var text: String) : Parcelable
}