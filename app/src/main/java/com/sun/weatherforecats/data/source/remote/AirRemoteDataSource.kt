package com.sun.weatherforecats.data.source.remote

import com.sun.weatherforecats.coroutine.ApiResultHandler
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.api.AirApi
import com.sun.weatherforecats.data.api.response.AirCurrentResponse
import com.sun.weatherforecats.data.api.response.AirHistoryResponse
import com.sun.weatherforecats.data.api.response.AirHourlyResponse
import com.sun.weatherforecats.data.source.AirDataSource
import com.sun.weatherforecats.utils.Constants

class AirRemoteDataSource(
    private val airApi: AirApi
) : AirDataSource.Remote, ApiResultHandler() {
    override suspend fun getAirCurrent(
        city: String,
        key: String
    ): ResultCoroutine<AirCurrentResponse> = safeApiResult(
        call = { airApi.getAirCurrentAsync(city, key).await() },
        errorMessage = Constants.ERROR_MESSAGE
    )

    override suspend fun getAirHourly(
        city: String,
        key: String,
        hours: Int
    ): ResultCoroutine<AirHourlyResponse> = safeApiResult(
        call = { airApi.getAirHourlyAsync(city, key, hours).await() },
        errorMessage = Constants.ERROR_MESSAGE
    )

    override suspend fun getAirHistory(
        city: String,
        key: String,
        hours: Int
    ): ResultCoroutine<AirHistoryResponse> = safeApiResult(
        call = { airApi.getAirHistoryAsync(city, key, hours).await() },
        errorMessage = Constants.ERROR_MESSAGE
    )
}
