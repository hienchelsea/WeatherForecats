package com.sun.weatherforecats.ui.air.airhourly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.BuildConfig
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.model.AirHourly
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.data.repository.AirRemoteRepository
import com.sun.weatherforecats.data.repository.WeatherRemoteRepository
import com.sun.weatherforecats.ui.base.BaseViewModel
import com.sun.weatherforecats.utils.Constants
import kotlinx.coroutines.launch

class AirHourlyViewModel(
    private val weatherRemoteRepository: WeatherRemoteRepository,
    private val airRemoteRepository: AirRemoteRepository
) : BaseViewModel() {
    private val _temperatureHourly = MutableLiveData<List<WeatherHourly>>()
    val temperatureHourly: LiveData<List<WeatherHourly>>
        get() = _temperatureHourly

    private val _airHourly = MutableLiveData<List<AirHourly>>()
    val airHourly: LiveData<List<AirHourly>>
        get() = _airHourly

    fun getTemperatureHourly(city: String) = launch {
        when (val chapterResponse =
            weatherRemoteRepository.getWeatherHourly(city, BuildConfig.API_KEY, 24)) {
            is ResultCoroutine.Success -> {
                _temperatureHourly.postValue(chapterResponse.data.data)
            }
            is ResultCoroutine.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }

    fun getAirHourly(city: String) = launch {
        when (val chapterResponse =
            airRemoteRepository.getAirHourly(city, BuildConfig.API_KEY, 24)) {
            is ResultCoroutine.Success -> {
                _airHourly.postValue(chapterResponse.data.data)
            }
            is ResultCoroutine.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }
}
