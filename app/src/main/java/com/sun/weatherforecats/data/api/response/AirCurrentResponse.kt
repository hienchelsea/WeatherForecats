package com.sun.weatherforecats.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun.weatherforecats.data.model.AirCurrent

data class AirCurrentResponse(
    @SerializedName("data")
    @Expose
    val data: List<AirCurrent>,
    @SerializedName("city_name")
    @Expose
    val cityName: String,
    @SerializedName("lon")
    @Expose
    val lon: String,
    @SerializedName("timezone")
    @Expose
    val timezone: String,
    @SerializedName("lat")
    @Expose
    val lat: String,
    @SerializedName("country_code")
    @Expose
    val countryCode: String,
    @SerializedName("state_code")
    @Expose
    val stateCode: String
)
