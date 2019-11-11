package com.sun.weatherforecats.di

import com.sun.weatherforecats.ui.air.airhistory.AirHistoryDetailViewModel
import com.sun.weatherforecats.ui.air.airhistory.AirrHistoryViewModel
import com.sun.weatherforecats.ui.air.airhourly.AirHourlyDetailViewModel
import com.sun.weatherforecats.ui.air.airhourly.AirHourlyViewModel
import com.sun.weatherforecats.ui.air.airnow.AirNowDetailViewModel
import com.sun.weatherforecats.ui.air.airnow.AirNowViewModel
import com.sun.weatherforecats.ui.home.HomeViewModel
import com.sun.weatherforecats.ui.managercity.CityyActivityViewModel
import com.sun.weatherforecats.ui.setting.SettingViewModel
import com.sun.weatherforecats.ui.temperature.temperaturedaily.TemperatureDailyDetailViewModel
import com.sun.weatherforecats.ui.temperature.temperaturedaily.TemperatureDailyViewModel
import com.sun.weatherforecats.ui.temperature.temperaturehourly.TemperatureHourlyDetailViewModel
import com.sun.weatherforecats.ui.temperature.temperaturehourly.TemperatureHourlyViewModel
import com.sun.weatherforecats.ui.temperature.temperaturenow.TemperatureCurrentDetailViewModel
import com.sun.weatherforecats.ui.temperature.temperaturenow.TemperatureNowViewModel
import com.sun.weatherforecats.utils.KoinNames
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            geocoder = get(named(KoinNames.GEOCOCER)),
            weatherRemoteRepository = get(named(KoinNames.WEATHER_REMOTE_REPOSITORY)),
            airRemoteRepository = get(named(KoinNames.AIR_REMOTE_REPOSITORY)),
            cityLocalRepository = get(named(KoinNames.CITY_LOCAL_REPOSITORY))
        )
    }
    viewModel {
        TemperatureNowViewModel(
            weatherRemoteRepository = get(named(KoinNames.WEATHER_REMOTE_REPOSITORY))
        )
    }
    viewModel {
        TemperatureDailyViewModel(
            weatherRemoteRepository = get(named(KoinNames.WEATHER_REMOTE_REPOSITORY))
        )
    }
    viewModel {
        TemperatureHourlyViewModel(
            weatherRemoteRepository = get(named(KoinNames.WEATHER_REMOTE_REPOSITORY))
        )
    }
    viewModel {
        TemperatureCurrentDetailViewModel()
    }
    viewModel {
        TemperatureHourlyDetailViewModel()
    }
    viewModel {
        TemperatureDailyDetailViewModel()
    }
    viewModel {
        AirNowViewModel(
            weatherRemoteRepository = get(named(KoinNames.WEATHER_REMOTE_REPOSITORY)),
            airRemoteRepository = get(named(KoinNames.AIR_REMOTE_REPOSITORY))
        )
    }
    viewModel {
        AirNowDetailViewModel()
    }
    viewModel {
        AirHourlyViewModel(
            weatherRemoteRepository = get(named(KoinNames.WEATHER_REMOTE_REPOSITORY)),
            airRemoteRepository = get(named(KoinNames.AIR_REMOTE_REPOSITORY))
        )
    }
    viewModel {
        AirHourlyDetailViewModel()
    }
    viewModel {
        AirrHistoryViewModel(airRemoteRepository = get(named(KoinNames.AIR_REMOTE_REPOSITORY)))
    }
    viewModel {
        AirHistoryDetailViewModel()
    }
    viewModel {
        SettingViewModel()
    }
    viewModel {
        CityyActivityViewModel(
            weatherRemoteRepository = get(named(KoinNames.WEATHER_REMOTE_REPOSITORY)),
            cityLocalRepository = get(named(KoinNames.CITY_LOCAL_REPOSITORY))
        )
    }
}
