package com.sun.weatherforecats.data.source

import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.api.response.AirCurrentResponse
import com.sun.weatherforecats.data.api.response.AirHistoryResponse
import com.sun.weatherforecats.data.api.response.AirHourlyResponse

interface AirDataSource {
    interface Remote {
        suspend fun getAirCurrent(
            city: String,
            key: String
        ): ResultCoroutine<AirCurrentResponse>

        suspend fun getAirHourly(
            city: String,
            key: String,
            hours: Int
        ): ResultCoroutine<AirHourlyResponse>

        suspend fun getAirHistory(
            city: String,
            key: String,
            hours: Int
        ): ResultCoroutine<AirHistoryResponse>
    }
}
