package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherCurrent(
    @SerializedName("rh")
    @Expose
    val rh: Int,
    @SerializedName("pod")
    @Expose
    val pod: String,
    @SerializedName("lon")
    @Expose
    val lon: Double,
    @SerializedName("pres")
    @Expose
    val pres: Double,
    @SerializedName("timezone")
    @Expose
    val timezone: String,
    @SerializedName("ob_time")
    @Expose
    val obTime: String,
    @SerializedName("country_code")
    @Expose
    val countryCode: String,
    @SerializedName("clouds")
    @Expose
    val clouds: Int,
    @SerializedName("ts")
    @Expose
    val ts: Int,
    @SerializedName("solar_rad")
    @Expose
    val solarRad: Double,
    @SerializedName("state_code")
    @Expose
    val stateCode: String,
    @SerializedName("city_name")
    @Expose
    val cityName: String,
    @SerializedName("wind_spd")
    @Expose
    val windSpd: Double,
    @SerializedName("last_ob_time")
    @Expose
    val lastObTime: String,
    @SerializedName("wind_cdir_full")
    @Expose
    val windCdirFull: String,
    @SerializedName("wind_cdir")
    @Expose
    val windCdir: String,
    @SerializedName("slp")
    @Expose
    val slp: Double,
    @SerializedName("vis")
    @Expose
    val vis: Double,
    @SerializedName("h_angle")
    @Expose
    val hAngle: Int,
    @SerializedName("sunset")
    @Expose
    val sunset: String,
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
    @SerializedName("precip")
    @Expose
    val precip: Double,
    @SerializedName("wind_dir")
    @Expose
    val windDir: Int,
    @SerializedName("sunrise")
    @Expose
    val sunrise: String,
    @SerializedName("ghi")
    @Expose
    val ghi: Double,
    @SerializedName("dhi")
    @Expose
    val dhi: Double,
    @SerializedName("aqi")
    @Expose
    val aqi: Int? = null,
    @SerializedName("lat")
    @Expose
    val lat: Double,
    @SerializedName("weather")
    @Expose
    val weather: Weather,
    @SerializedName("datetime")
    @Expose
    val datetime: String,
    @SerializedName("temp")
    @Expose
    val temp: String,
    @SerializedName("station")
    @Expose
    val station: String,
    @SerializedName("elev_angle")
    @Expose
    val elevAngle: Double,
    @SerializedName("app_temp")
    @Expose
    val appTemp: Double
)
