package com.sun.weatherforecats.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun.weatherforecats.data.model.WeatherHourly

data class WeatherHourlyResponse(
    @SerializedName("data")
    @Expose
    val data: List<WeatherHourly>
)
