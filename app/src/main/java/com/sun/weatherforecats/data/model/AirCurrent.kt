package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AirCurrent(
    @SerializedName("o3")
    @Expose
    val o3: String,
    @SerializedName("so2")
    @Expose
    val so2: String,
    @SerializedName("no2")
    @Expose
    val no2: String,
    @SerializedName("aqi")
    @Expose
    val aqi: String,
    @SerializedName("co")
    @Expose
    val co: String,
    @SerializedName("pm10")
    @Expose
    val pm10: String,
    @SerializedName("pm25")
    @Expose
    val pm25: String
)
