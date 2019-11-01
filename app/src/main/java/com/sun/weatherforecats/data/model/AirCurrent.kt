package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AirCurrent(
    @SerializedName("o3")
    @Expose
    val o3: Double,
    @SerializedName("so2")
    @Expose
    val so2: Double,
    @SerializedName("no2")
    @Expose
    val no2: Double,
    @SerializedName("aqi")
    @Expose
    val aqi: String,
    @SerializedName("co")
    @Expose
    val co: Double,
    @SerializedName("pm10")
    @Expose
    val pm10: Double,
    @SerializedName("pm25")
    @Expose
    val pm25: Double
)
