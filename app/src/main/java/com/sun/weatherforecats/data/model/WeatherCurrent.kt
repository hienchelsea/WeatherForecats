package com.sun.weatherforecats.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherCurrent(
    @SerializedName("rh")
    @Expose
    private val rh: Int,
    @SerializedName("pod")
    @Expose
    private val pod: String,
    @SerializedName("lon")
    @Expose
    private val lon: Double,
    @SerializedName("pres")
    @Expose
    private val pres: Double,
    @SerializedName("timezone")
    @Expose
    private val timezone: String,
    @SerializedName("ob_time")
    @Expose
    private val obTime: String,
    @SerializedName("country_code")
    @Expose
    private val countryCode: String,
    @SerializedName("clouds")
    @Expose
    private val clouds: Int,
    @SerializedName("ts")
    @Expose
    private val ts: Int,
    @SerializedName("solar_rad")
    @Expose
    private val solarRad: Double,
    @SerializedName("state_code")
    @Expose
    private val stateCode: String,
    @SerializedName("city_name")
    @Expose
    private val cityName: String,
    @SerializedName("wind_spd")
    @Expose
    private val windSpd: Double,
    @SerializedName("last_ob_time")
    @Expose
    private val lastObTime: String,
    @SerializedName("wind_cdir_full")
    @Expose
    private val windCdirFull: String,
    @SerializedName("wind_cdir")
    @Expose
    private val windCdir: String,
    @SerializedName("slp")
    @Expose
    private val slp: Int,
    @SerializedName("vis")
    @Expose
    private val vis: Int,
    @SerializedName("h_angle")
    @Expose
    private val hAngle: Int,
    @SerializedName("sunset")
    @Expose
    private val sunset: String,
    @SerializedName("dni")
    @Expose
    private val dni: Double,
    @SerializedName("dewpt")
    @Expose
    private val dewpt: Double,
    @SerializedName("snow")
    @Expose
    private val snow: Int,
    @SerializedName("uv")
    @Expose
    private val uv: Double,
    @SerializedName("precip")
    @Expose
    private val precip: Int,
    @SerializedName("wind_dir")
    @Expose
    private val windDir: Int,
    @SerializedName("sunrise")
    @Expose
    private val sunrise: String,
    @SerializedName("ghi")
    @Expose
    private val ghi: Double,
    @SerializedName("dhi")
    @Expose
    private val dhi: Double,
    @SerializedName("aqi")
    @Expose
    private val aqi: Int? = null,
    @SerializedName("lat")
    @Expose
    private val lat: Double,
    @SerializedName("weather")
    @Expose
    private val weather: Weather,
    @SerializedName("datetime")
    @Expose
    private val datetime: String,
    @SerializedName("temp")
    @Expose
    private val temp: Int,
    @SerializedName("station")
    @Expose
    private val station: String,
    @SerializedName("elev_angle")
    @Expose
    private val elevAngle: Double,
    @SerializedName("app_temp")
    @Expose
    private val appTemp: Double
)
