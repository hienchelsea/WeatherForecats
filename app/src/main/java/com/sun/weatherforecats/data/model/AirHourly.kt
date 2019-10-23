package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AirHourly(
    @SerializedName("aqi")
    @Expose
    private val aqi: Int,
    @SerializedName("pm10")
    @Expose
    private val pm10: Double,
    @SerializedName("pm25")
    @Expose
    private val pm25: Double,
    @SerializedName("o3")
    @Expose
    private val o3: Double,
    @SerializedName("timestamp_local")
    @Expose
    private val timestampLocal: String,
    @SerializedName("so2")
    @Expose
    private val so2: Double,
    @SerializedName("no2")
    @Expose
    private val no2: Double,
    @SerializedName("timestamp_utc")
    @Expose
    private val timestampUtc: String,
    @SerializedName("datetime")
    @Expose
    private val datetime: String
)
