package com.khanhlh.basemvvmkt.model

import android.graphics.Bitmap
import android.view.View
import com.google.firebase.firestore.PropertyName

data class Device(
    val id: String,
    @PropertyName("name")
    val name: String,
    @PropertyName("temp")
    val temp: String,
    @PropertyName("threshold")
    val threshold: String,
    val image: Bitmap? = null,
    @PropertyName("temp")
    val type: Long = 0
) {
    val warning: Int
        get() = if (temp.toDouble() > threshold.toDouble()) View.VISIBLE else View.GONE
    val flashing: Boolean
        get() = temp.toDouble() > threshold.toDouble()
    val tempDisplay: String
        get() = temp + 0x00B0.toChar() + "C"
}