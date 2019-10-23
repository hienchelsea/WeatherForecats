package com.sun.weatherforecats.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sun.weatherforecats.data.api.APIFactory
import com.sun.weatherforecats.data.api.AirApi
import com.sun.weatherforecats.data.api.ApiConstants
import com.sun.weatherforecats.data.api.WeatherApi
import com.sun.weatherforecats.data.db.AppDatabase
import com.sun.weatherforecats.utils.KoinNames
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { androidApplication().resources }

    single(named(KoinNames.APP_DATABASE)) {
        AppDatabase.getInstance(androidContext())
    }

    single(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY)) {
        CoroutineCallAdapterFactory()
    }

    single(named(KoinNames.GSON_CONVERTER_FACTORY)) {
        GsonConverterFactory.create()
    }

    single(named(KoinNames.API_BASE_URL)) {
        ApiConstants.API_BASE_URL
    }

    single(named(KoinNames.WEATHER_API)) {
        APIFactory.buildRestApi(
            baseUrl = get(named(KoinNames.API_BASE_URL)),
            restApi = WeatherApi::class.java,
            converterFactory = get(named(KoinNames.GSON_CONVERTER_FACTORY)),
            callAdapterFactory = get(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY))
        )
    }

    single(named(KoinNames.AIR_API)) {
        APIFactory.buildRestApi(
            baseUrl = get(named(KoinNames.API_BASE_URL)),
            restApi = AirApi::class.java,
            converterFactory = get(named(KoinNames.GSON_CONVERTER_FACTORY)),
            callAdapterFactory = get(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY))
        )
    }
}
