package com.coolkosta.aplicationfortraning.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Options(val number: Int, var isEvenNumber: Boolean) : Parcelable {

    init {
        isEvenNumber = number % 2 == 0
    }

    companion object {
        @JvmStatic
        val DEFAULT = Options(2, true)
    }
}

