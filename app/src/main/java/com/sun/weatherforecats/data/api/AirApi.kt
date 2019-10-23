package com.sun.weatherforecats.data.api

import com.sun.weatherforecats.data.api.response.AirCurrentResponse
import com.sun.weatherforecats.data.api.response.AirHistoryResponse
import com.sun.weatherforecats.data.api.response.AirHourlyResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AirApi {

    @GET(PATH_AIR_CURRENT)
    fun getAirCurrent(
        @Query(QUERY_CITY) city: String,
        @Query(QUERY_KEY) key: String
    ): Deferred<Response<AirCurrentResponse>>

    @GET(PATH_AIR_HOURLY)
    fun getAirHourly(
        @Query(QUERY_CITY) city: String,
        @Query(QUERY_KEY) key: String,
        @Query(QUERY_HOURS) hours: Int
    ): Deferred<Response<AirHourlyResponse>>

    @GET(PATH_AIR_HISTORY)
    fun getAirDaily(
        @Query(QUERY_CITY) city: String,
        @Query(QUERY_KEY) key: String,
        @Query(QUERY_HOURS) hours: Int
    ): Deferred<Response<AirHistoryResponse>>
}
