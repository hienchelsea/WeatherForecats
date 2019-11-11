package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDaily(
    @SerializedName("moonrise_ts")
    @Expose
    val moonriseTs: String,
    @SerializedName("wind_cdir")
    @Expose
    val windCdir: String,
    @SerializedName("rh")
    @Expose
    val rh: String,
    @SerializedName("pres")
    @Expose
    val pres: String,
    @SerializedName("high_temp")
    @Expose
    val highTemp: String,
    @SerializedName("sunset_ts")
    @Expose
    val sunsetTs: String,
    @SerializedName("ozone")
    @Expose
    val ozone: String,
    @SerializedName("moon_phase")
    @Expose
    val moonPhase: String,
    @SerializedName("wind_gust_spd")
    @Expose
    val windGustSpd: String,
    @SerializedName("snow_depth")
    @Expose
    val snowDepth: String,
    @SerializedName("clouds")
    @Expose
    val clouds: String,
    @SerializedName("ts")
    @Expose
    val ts: String,
    @SerializedName("sunrise_ts")
    @Expose
    val sunriseTs: String,
    @SerializedName("app_min_temp")
    @Expose
    val appMinTemp: String,
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
    @SerializedName("valid_date")
    @Expose
    val validDate: String,
    @SerializedName("app_max_temp")
    @Expose
    val appMaxTemp: String,
    @SerializedName("vis")
    @Expose
    val vis: String,
    @SerializedName("dewpt")
    @Expose
    val dewpt: String,
    @SerializedName("snow")
    @Expose
    val snow: String,
    @SerializedName("uv")
    @Expose
    val uv: String,
    @SerializedName("weather")
    @Expose
    val weather: Weather,
    @SerializedName("wind_dir")
    @Expose
    val windDir: String,
    @SerializedName("max_dhi")
    @Expose
    val maxDhi: String,
    @SerializedName("clouds_hi")
    @Expose
    val cloudsHi: String,
    @SerializedName("precip")
    @Expose
    val precip: String,
    @SerializedName("low_temp")
    @Expose
    val lowTemp: String,
    @SerializedName("max_temp")
    @Expose
    val maxTemp: String,
    @SerializedName("moonset_ts")
    @Expose
    val moonsetTs: String,
    @SerializedName("datetime")
    @Expose
    val datetime: String,
    @SerializedName("temp")
    @Expose
    val temp: Double,
    @SerializedName("min_temp")
    @Expose
    val minTemp: String,
    @SerializedName("clouds_mid")
    @Expose
    val cloudsMid: String,
    @SerializedName("clouds_low")
    @Expose
    val cloudsLow: String
)
