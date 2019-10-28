package com.sun.weatherforecats.di

import com.sun.weatherforecats.data.source.local.CityLocalDataSource
import com.sun.weatherforecats.data.source.remote.AirRemoteDataSource
import com.sun.weatherforecats.data.source.remote.WeatherRemoteDataSource
import com.sun.weatherforecats.utils.KoinNames
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sourceModule = module {

    single(named(KoinNames.AIR_REMOTE_DATA_SOURCE)) {
        AirRemoteDataSource(airApi = get(named(KoinNames.AIR_API)))
    }

    single(named(KoinNames.WEATHER_REMOTE_DATA_SOURCE)) {
        WeatherRemoteDataSource(weatherApi = get(named(KoinNames.WEATHER_API)))
    }

    single(named(KoinNames.CITY_LOCAL_DATA_SOURCE)) {
        CityLocalDataSource(appDatabase = get(named(KoinNames.APP_DATABASE)))
    }

}
