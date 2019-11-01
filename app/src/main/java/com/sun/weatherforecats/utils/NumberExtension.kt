package com.sun.weatherforecats.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun formatMonth(s: String): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date = formatter.parse(s)
    val format = SimpleDateFormat("hh:mm", Locale.US)
    return format.format(date)
}

