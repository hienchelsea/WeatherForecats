package com.sun.weatherforecats.data.api

import com.sun.weatherforecats.data.api.response.WeatherCurrentReponse
import com.sun.weatherforecats.data.api.response.WeatherDailyResponse
import com.sun.weatherforecats.data.api.response.WeatherHourlyResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(PATH_WEATHER_CURRENT)
    fun getWeatherCurrentAsync(
        @Query(QUERY_CITY) city: String,
        @Query(QUERY_KEY) key: String
    ): Deferred<Response<WeatherCurrentReponse>>

    @GET(PATH_WEATHER_HOURLY)
    fun getWeatherHourlyAsync(
        @Query(QUERY_CITY) city: String,
        @Query(QUERY_KEY) key: String,
        @Query(QUERY_HOURS) hours: Int
    ): Deferred<Response<WeatherHourlyResponse>>

    @GET(PATH_WEATHER_DAILY)
    fun getWeatherDailyAsync(
        @Query(QUERY_CITY) city: String,
        @Query(QUERY_KEY) key: String,
        @Query(QUERY_DAYS) days: Int
    ): Deferred<Response<WeatherDailyResponse>>
}
