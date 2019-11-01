package com.sun.weatherforecats.data.source

import com.sun.weatherforecats.coroutine.ResultCoroutines
import com.sun.weatherforecats.data.api.response.WeatherCurrentReponse
import com.sun.weatherforecats.data.api.response.WeatherDailyResponse
import com.sun.weatherforecats.data.api.response.WeatherHourlyResponse

interface WeatherDataSource {
    interface Remote {
        suspend fun getWeatherCurrent(
            city: String,
            key: String
        ): ResultCoroutines<WeatherCurrentReponse>

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
