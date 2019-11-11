package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherHourly(
    @SerializedName("wind_cdir")
    @Expose
    val windCdir: String,
    @SerializedName("rh")
    @Expose
    val rh: String,
    @SerializedName("pod")
    @Expose
    val pod: String,
    @SerializedName("timestamp_utc")
    @Expose
    val timestampUtc: String,
    @SerializedName("pres")
    @Expose
    val pres: String,
    @SerializedName("solar_rad")
    @Expose
    val solarRad: String,
    @SerializedName("ozone")
    @Expose
    val ozone: String,
    @SerializedName("weather")
    @Expose
    val weather: Weather,
    @SerializedName("wind_gust_spd")
    @Expose
    val windGustSpd: String,
    @SerializedName("timestamp_local")
    @Expose
    val timestampLocal: String,
    @SerializedName("snow_depth")
    @Expose
    val snowDepth: String,
    @SerializedName("clouds")
    @Expose
    val clouds: String,
    @SerializedName("ts")
    @Expose
    val ts: String,
    @SerializedName("wind_spd")
    @Expose
    val windSpd: String,
    @SerializedName("pop")
    @Expose
    val pop: String,
    @SerializedName("wind_cdir_full")
    @Expose
    val windCdirFull: String,
    @SerializedName("slp")
    @Expose
    val slp: String,
    @SerializedName("dni")
    @Expose
    val dni: String,
    @SerializedName("dewpt")
    @Expose
    val dewpt: String,
    @SerializedName("snow")
    @Expose
    val snow: String,
    @SerializedName("uv")
    @Expose
    val uv: String,
    @SerializedName("wind_dir")
    @Expose
    val windDir: String,
    @SerializedName("clouds_hi")
    @Expose
    val cloudsHi: String,
    @SerializedName("precip")
    @Expose
    val precip: String,
    @SerializedName("vis")
    @Expose
    val vis: Double,
    @SerializedName("dhi")
    @Expose
    val dhi: Double,
    @SerializedName("app_temp")
    @Expose
    val appTemp: String,
    @SerializedName("datetime")
    @Expose
    val datetime: String,
    @SerializedName("temp")
    @Expose
    val temp: String,
    @SerializedName("ghi")
    @Expose
    val ghi: String,
    @SerializedName("clouds_mid")
    @Expose
    val cloudsMid: Int,
    @SerializedName("clouds_low")
    @Expose
    val cloudsLow: Int
)
