package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDaily(
    @SerializedName("moonrise_ts")
    @Expose
    private val moonriseTs: Int,
    @SerializedName("wind_cdir")
    @Expose
    private val windCdir: String,
    @SerializedName("rh")
    @Expose
    private val rh: Int,
    @SerializedName("pres")
    @Expose
    private val pres: Double,
    @SerializedName("high_temp")
    @Expose
    private val highTemp: Int,
    @SerializedName("sunset_ts")
    @Expose
    private val sunsetTs: Int,
    @SerializedName("ozone")
    @Expose
    private val ozone: Double,
    @SerializedName("moon_phase")
    @Expose
    private val moonPhase: Double,
    @SerializedName("wind_gust_spd")
    @Expose
    private val windGustSpd: Double,
    @SerializedName("snow_depth")
    @Expose
    private val snowDepth: Int,
    @SerializedName("clouds")
    @Expose
    private val clouds: Int,
    @SerializedName("ts")
    @Expose
    private val ts: Int,
    @SerializedName("sunrise_ts")
    @Expose
    private val sunriseTs: Int,
    @SerializedName("app_min_temp")
    @Expose
    private val appMinTemp: Double,
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
    @SerializedName("valid_date")
    @Expose
    private val validDate: String,
    @SerializedName("app_max_temp")
    @Expose
    private val appMaxTemp: Double,
    @SerializedName("vis")
    @Expose
    private val vis: Double? = null,
    @SerializedName("dewpt")
    @Expose
    private val dewpt: Double,
    @SerializedName("snow")
    @Expose
    private val snow: Int,
    @SerializedName("uv")
    @Expose
    private val uv: Double,
    @SerializedName("weather")
    @Expose
    private val weather: Weather,
    @SerializedName("wind_dir")
    @Expose
    private val windDir: Int,
    @SerializedName("max_dhi")
    @Expose
    private val maxDhi: Any,
    @SerializedName("clouds_hi")
    @Expose
    private val cloudsHi: Int,
    @SerializedName("precip")
    @Expose
    private val precip: Double,
    @SerializedName("low_temp")
    @Expose
    private val lowTemp: Double,
    @SerializedName("max_temp")
    @Expose
    private val maxTemp: Double,
    @SerializedName("moonset_ts")
    @Expose
    private val moonsetTs: Int,
    @SerializedName("datetime")
    @Expose
    private val datetime: String,
    @SerializedName("temp")
    @Expose
    private val temp: Double,
    @SerializedName("min_temp")
    @Expose
    private val minTemp: Double,
    @SerializedName("clouds_mid")
    @Expose
    private val cloudsMid: Int,
    @SerializedName("clouds_low")
    @Expose
    private val cloudsLow: Int
)
