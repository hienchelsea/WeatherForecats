package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AirHourly(
    @SerializedName("aqi")
    @Expose
    val aqi: String,
    @SerializedName("pm10")
    @Expose
    val pm10: String,
    @SerializedName("pm25")
    @Expose
    val pm25: String,
    @SerializedName("o3")
    @Expose
    val o3: String,
    @SerializedName("timestamp_local")
    @Expose
    val timestampLocal: String,
    @SerializedName("so2")
    @Expose
    val so2: String,
    @SerializedName("no2")
    @Expose
    val no2: String,
    @SerializedName("timestamp_utc")
    @Expose
    val timestampUtc: String,
    @SerializedName("datetime")
    @Expose
    val datetime: String
)
