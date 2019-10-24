package com.sun.weatherforecats.data.source

import com.sun.weatherforecats.coroutine.ResultCoroutines
import com.sun.weatherforecats.data.api.response.AirCurrentResponse
import com.sun.weatherforecats.data.api.response.AirHistoryResponse
import com.sun.weatherforecats.data.api.response.AirHourlyResponse

interface AirDataSource {
    interface Remote {
        suspend fun getAirCurrent(
            city: String,
            key: String
        ): ResultCoroutines<AirCurrentResponse>

        suspend fun getAirHourly(
            city: String,
            key: String,
            hours: Int
        ): ResultCoroutines<AirHourlyResponse>

        suspend fun getAirHistory(
            city: String,
            key: String,
            hours: Int
        ): ResultCoroutines<AirHistoryResponse>
    }
}
