package com.coolkosta.aplicationfortraning.data

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.parcelize.Parcelize

open class GeneralViewModel : ViewModel() {
    val stateMessages: LiveData<Messages> get() = _stateMessages
    private val _stateMessages = MutableLiveData<Messages>()

    fun initState(state: Messages) {
        _stateMessages.value = state
    }

    fun messageForActivity(message: String) {
        val newMessage = _stateMessages.value?.copy(activityMessage = message)
        _stateMessages.value = newMessage
    }

    fun messageFromFirstFragment(message: String) {
        val newMessage = _stateMessages.value?.copy(secondFragment = message)
        _stateMessages.value = newMessage
    }

    fun messageFromSecondFragment(message: String) {
        val newMessage = _stateMessages.value?.copy(firstFragment = message)
        _stateMessages.value = newMessage
    }

    @Parcelize
    data class Messages(
        val firstFragment: String,
        val secondFragment: String,
        val activityMessage: String
    ) : Parcelable
}