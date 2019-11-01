package com.sun.weatherforecats.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun.weatherforecats.data.model.WeatherCurrent

data class WeatherCurrentReponse(

    @SerializedName("data")
    @Expose
    val data: List<WeatherCurrent>
)
