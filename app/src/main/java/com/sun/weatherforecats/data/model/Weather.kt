package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("icon")
    @Expose
    private val icon: String,
    @SerializedName("code")
    @Expose
    private val code: Int,
    @SerializedName("description")
    @Expose
    private val description: String
)
