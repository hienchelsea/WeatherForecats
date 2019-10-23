package com.sun.weatherforecats.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun.weatherforecats.data.model.AirHistory

data class AirHistoryResponse(
    @SerializedName("data")
    @Expose
    private val data: List<AirHistory>,
    @SerializedName("city_name")
    @Expose
    private val cityName: String,
    @SerializedName("lon")
    @Expose
    private val lon: String,
    @SerializedName("timezone")
    @Expose
    private val timezone: String,
    @SerializedName("lat")
    @Expose
    private val lat: String,
    @SerializedName("country_code")
    @Expose
    private val countryCode: String,
    @SerializedName("state_code")
    @Expose
    private val stateCode: String
)
