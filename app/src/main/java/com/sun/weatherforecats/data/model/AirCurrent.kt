package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AirCurrent(
    @SerializedName("o3")
    @Expose
    private val o3: Double,
    @SerializedName("so2")
    @Expose
    private val so2: Double,
    @SerializedName("no2")
    @Expose
    private val no2: Double,
    @SerializedName("aqi")
    @Expose
    private val aqi: Int,
    @SerializedName("co")
    @Expose
    private val co: Double,
    @SerializedName("pm10")
    @Expose
    private val pm10: Double,
    @SerializedName("pm25")
    @Expose
    private val pm25: Int
)
