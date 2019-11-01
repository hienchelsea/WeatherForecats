package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AirHistory(
    @SerializedName("aqi")
    @Expose
    val aqi: Int,
    @SerializedName("pm10")
    @Expose
    val pm10: Double,
    @SerializedName("pm25")
    @Expose
    val pm25: Double,
    @SerializedName("o3")
    @Expose
    val o3: Double,
    @SerializedName("timestamp_local")
    @Expose
    val timestampLocal: String,
    @SerializedName("so2")
    @Expose
    val so2: Double,
    @SerializedName("no2")
    @Expose
    val no2: Double,
    @SerializedName("timestamp_utc")
    @Expose
    val timestampUtc: String,
    @SerializedName("datetime")
    @Expose
    val datetime: String,
    @SerializedName("co")
    @Expose
    val co: Double,
    @SerializedName("ts")
    @Expose
    val ts: Int
)
