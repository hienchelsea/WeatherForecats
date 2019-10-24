package com.sun.weatherforecats.data.repository

import com.sun.weatherforecats.coroutine.ResultCoroutines
import com.sun.weatherforecats.data.api.response.AirCurrentResponse
import com.sun.weatherforecats.data.api.response.AirHistoryResponse
import com.sun.weatherforecats.data.api.response.AirHourlyResponse
import com.sun.weatherforecats.data.source.AirDataSource

class AirRemoteRepository(
    private val airDataSource: AirDataSource.Remote
) : AirDataSource.Remote {
    override suspend fun getAirCurrent(
        city: String,
        key: String
    ): ResultCoroutines<AirCurrentResponse> = airDataSource.getAirCurrent(city, key)

    override suspend fun getAirHourly(
        city: String,
        key: String,
        hours: Int
    ): ResultCoroutines<AirHourlyResponse> = airDataSource.getAirHourly(city, key, hours)

    override suspend fun getAirHistory(
        city: String,
        key: String,
        hours: Int
    ): ResultCoroutines<AirHistoryResponse> = airDataSource.getAirHistory(city, key, hours)
}
