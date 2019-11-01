package com.sun.weatherforecats.data.repository

import com.sun.weatherforecats.coroutine.ResultCoroutines
import com.sun.weatherforecats.data.api.response.WeatherCurrentReponse
import com.sun.weatherforecats.data.api.response.WeatherDailyResponse
import com.sun.weatherforecats.data.api.response.WeatherHourlyResponse
import com.sun.weatherforecats.data.source.WeatherDataSource

class WeatherRemoteRepository(
    private val weatherDataSource: WeatherDataSource.Remote
) : WeatherDataSource.Remote {
    override suspend fun getWeatherCurrent(
        city: String,
        key: String
    ): ResultCoroutines<WeatherCurrentReponse> = weatherDataSource.getWeatherCurrent(city, key)

    override suspend fun getWeatherHourly(
        city: String,
        key: String,
        hours: Int
    ): ResultCoroutines<WeatherHourlyResponse> =
        weatherDataSource.getWeatherHourly(city, key, hours)

    override suspend fun getWeatherDaily(
        city: String,
        key: String,
        days: Int
    ): ResultCoroutines<WeatherDailyResponse> = weatherDataSource.getWeatherDaily(city, key, days)

}
