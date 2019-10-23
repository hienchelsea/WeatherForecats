package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherHourly(
    @SerializedName("wind_cdir")
    @Expose
    private val windCdir: String,
    @SerializedName("rh")
    @Expose
    private val rh: Int,
    @SerializedName("pod")
    @Expose
    private val pod: String,
    @SerializedName("timestamp_utc")
    @Expose
    private val timestampUtc: String,
    @SerializedName("pres")
    @Expose
    private val pres: Double,
    @SerializedName("solar_rad")
    @Expose
    private val solarRad: Double,
    @SerializedName("ozone")
    @Expose
    private val ozone: Double,
    @SerializedName("weather")
    @Expose
    private val weather: Weather,
    @SerializedName("wind_gust_spd")
    @Expose
    private val windGustSpd: Double,
    @SerializedName("timestamp_local")
    @Expose
    private val timestampLocal: String,
    @SerializedName("snow_depth")
    @Expose
    private val snowDepth: Int,
    @SerializedName("clouds")
    @Expose
    private val clouds: Int,
    @SerializedName("ts")
    @Expose
    private val ts: Int,
    @SerializedName("wind_spd")
    @Expose
    private val windSpd: Double,
    @SerializedName("pop")
    @Expose
    private val pop: Int,
    @SerializedName("wind_cdir_full")
    @Expose
    private val windCdirFull: String,
    @SerializedName("slp")
    @Expose
    private val slp: Double,
    @SerializedName("dni")
    @Expose
    private val dni: Double,
    @SerializedName("dewpt")
    @Expose
    private val dewpt: Int,
    @SerializedName("snow")
    @Expose
    private val snow: Int,
    @SerializedName("uv")
    @Expose
    private val uv: Double,
    @SerializedName("wind_dir")
    @Expose
    private val windDir: Int,
    @SerializedName("clouds_hi")
    @Expose
    private val cloudsHi: Int,
    @SerializedName("precip")
    @Expose
    private val precip: Double,
    @SerializedName("vis")
    @Expose
    private val vis: Double,
    @SerializedName("dhi")
    @Expose
    private val dhi: Double,
    @SerializedName("app_temp")
    @Expose
    private val appTemp: Double,
    @SerializedName("datetime")
    @Expose
    private val datetime: String,
    @SerializedName("temp")
    @Expose
    private val temp: Double,
    @SerializedName("ghi")
    @Expose
    private val ghi: Double,
    @SerializedName("clouds_mid")
    @Expose
    private val cloudsMid: Int,
    @SerializedName("clouds_low")
    @Expose
    private val cloudsLow: Int
)
