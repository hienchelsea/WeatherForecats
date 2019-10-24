package com.sun.weatherforecats.di

import com.sun.weatherforecats.data.repository.AirRemoteRepository
import com.sun.weatherforecats.data.repository.CityLocalRepository
import com.sun.weatherforecats.data.repository.WeatherRemoteRepository
import com.sun.weatherforecats.utils.KoinNames
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule: Module = module {

    single(named(KoinNames.AIR_REMOTE_REPOSITORY)) {
        AirRemoteRepository(airDataSource = get(named(KoinNames.AIR_REMOTE_DATA_SOURCE)))
    }

    single(named(KoinNames.WEATHER_REMOTE_REPOSITORY)) {
        WeatherRemoteRepository(weatherDataSource = get(named(KoinNames.WEATHER_REMOTE_DATA_SOURCE)))
    }

    single(named(KoinNames.CITY_LOCAL_REPOSITORY)) {
        CityLocalRepository(cityDataSource = get(named(KoinNames.CITY_LOCAL_DATA_SOURCE)))
    }
}
