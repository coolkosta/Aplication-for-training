package com.coolkosta.aplicationfortraning

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Text(val message: String) : Parcelable {

    companion object {
        @JvmStatic
        val DEFAULT = Text("Hello, click om the button and change text")
    }
}

