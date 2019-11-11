package com.sun.weatherforecats.data.source.remote

import com.sun.weatherforecats.coroutine.ApiResultHandler
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.api.WeatherApi
import com.sun.weatherforecats.data.api.response.WeatherCurrentReponse
import com.sun.weatherforecats.data.api.response.WeatherDailyResponse
import com.sun.weatherforecats.data.api.response.WeatherHourlyResponse
import com.sun.weatherforecats.data.source.WeatherDataSource
import com.sun.weatherforecats.utils.Constants

class WeatherRemoteDataSource(
    private val weatherApi: WeatherApi
) : WeatherDataSource.Remote, ApiResultHandler() {

    override suspend fun getWeatherCurrent(
        city: String,
        key: String
    ): ResultCoroutine<WeatherCurrentReponse> = safeApiResult(
        call = { weatherApi.getWeatherCurrentAsync(city, key).await() },
        errorMessage = Constants.ERROR_MESSAGE
    )

    override suspend fun getWeatherHourly(
        city: String,
        key: String,
        hours: Int
    ): ResultCoroutine<WeatherHourlyResponse> = safeApiResult(
        call = { weatherApi.getWeatherHourlyAsync(city, key, hours).await() },
        errorMessage = Constants.ERROR_MESSAGE
    )

    override suspend fun getWeatherDaily(
        city: String,
        key: String,
        days: Int
    ): ResultCoroutine<WeatherDailyResponse> = safeApiResult(
        call = { weatherApi.getWeatherDailyAsync(city, key, days).await() },
        errorMessage = Constants.ERROR_MESSAGE
    )
}
