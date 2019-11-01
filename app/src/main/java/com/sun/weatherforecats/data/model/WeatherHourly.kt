package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherHourly(
    @SerializedName("wind_cdir")
    @Expose
    val windCdir: String,
    @SerializedName("rh")
    @Expose
    val rh: Int,
    @SerializedName("pod")
    @Expose
    val pod: String,
    @SerializedName("timestamp_utc")
    @Expose
    val timestampUtc: String,
    @SerializedName("pres")
    @Expose
    val pres: Double,
    @SerializedName("solar_rad")
    @Expose
    val solarRad: Double,
    @SerializedName("ozone")
    @Expose
    val ozone: Double,
    @SerializedName("weather")
    @Expose
    val weather: Weather,
    @SerializedName("wind_gust_spd")
    @Expose
    val windGustSpd: Double,
    @SerializedName("timestamp_local")
    @Expose
    val timestampLocal: String,
    @SerializedName("snow_depth")
    @Expose
    val snowDepth: Int,
    @SerializedName("clouds")
    @Expose
    val clouds: Int,
    @SerializedName("ts")
    @Expose
    val ts: Int,
    @SerializedName("wind_spd")
    @Expose
    val windSpd: Double,
    @SerializedName("pop")
    @Expose
    val pop: Int,
    @SerializedName("wind_cdir_full")
    @Expose
    val windCdirFull: String,
    @SerializedName("slp")
    @Expose
    val slp: Double,
    @SerializedName("dni")
    @Expose
    val dni: Double,
    @SerializedName("dewpt")
    @Expose
    val dewpt: Double,
    @SerializedName("snow")
    @Expose
    val snow: Int,
    @SerializedName("uv")
    @Expose
    val uv: Double,
    @SerializedName("wind_dir")
    @Expose
    val windDir: Int,
    @SerializedName("clouds_hi")
    @Expose
    val cloudsHi: Int,
    @SerializedName("precip")
    @Expose
    val precip: Double,
    @SerializedName("vis")
    @Expose
    val vis: Double,
    @SerializedName("dhi")
    @Expose
    val dhi: Double,
    @SerializedName("app_temp")
    @Expose
    val appTemp: Double,
    @SerializedName("datetime")
    @Expose
    val datetime: String,
    @SerializedName("temp")
    @Expose
    val temp: Double,
    @SerializedName("ghi")
    @Expose
    val ghi: Double,
    @SerializedName("clouds_mid")
    @Expose
    val cloudsMid: Int,
    @SerializedName("clouds_low")
    @Expose
    val cloudsLow: Int
)
