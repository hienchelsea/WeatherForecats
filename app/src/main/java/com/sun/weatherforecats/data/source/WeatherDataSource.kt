package com.sun.weatherforecats.data.source

import com.sun.weatherforecats.coroutine.ResultCoroutines
import com.sun.weatherforecats.data.api.response.WeatherDailyResponse
import com.sun.weatherforecats.data.api.response.WeatherHourlyResponse
import com.sun.weatherforecats.data.model.WeatherCurrent

interface WeatherDataSource {
    interface Remote {
        suspend fun getWeatherCurrent(
            city: String,
            key: String
        ): ResultCoroutines<WeatherCurrent>

        suspend fun getWeatherHourly(
            city: String,
            key: String,
            hours: Int
        ): ResultCoroutines<WeatherHourlyResponse>

        suspend fun getWeatherDaily(
            city: String,
            key: String,
            days: Int
        ): ResultCoroutines<WeatherDailyResponse>
    }
}
