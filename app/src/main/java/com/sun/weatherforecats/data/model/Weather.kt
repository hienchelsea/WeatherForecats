package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("icon")
    @Expose
    val icon: String,
    @SerializedName("code")
    @Expose
    val code: Int,
    @SerializedName("description")
    @Expose
    val description: String
)
