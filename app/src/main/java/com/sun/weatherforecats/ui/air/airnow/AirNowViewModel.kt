package com.sun.weatherforecats.ui.air.airnow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.BuildConfig
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.model.AirCurrent
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.data.repository.AirRemoteRepository
import com.sun.weatherforecats.data.repository.WeatherRemoteRepository
import com.sun.weatherforecats.ui.base.BaseViewModel
import com.sun.weatherforecats.utils.Constants
import kotlinx.coroutines.launch

class AirNowViewModel(
    private val weatherRemoteRepository: WeatherRemoteRepository,
    private val airRemoteRepository: AirRemoteRepository
) :
    BaseViewModel() {
    private val _temperatureCurrent = MutableLiveData<WeatherCurrent>()
    val temperatureCurrent: LiveData<WeatherCurrent>
        get() = _temperatureCurrent

    private val _airCurrent = MutableLiveData<AirCurrent>()
    val airCurrent: LiveData<AirCurrent>
        get() = _airCurrent


    fun getTemperatureCurrent(city: String) = launch {
        when (val chapterResponse =
            weatherRemoteRepository.getWeatherCurrent(city, BuildConfig.API_KEY)) {
            is ResultCoroutine.Success -> {
                _temperatureCurrent.postValue(chapterResponse.data.data[0])
            }
            is ResultCoroutine.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }

    fun getAirCurrent(city: String) = launch {
        when (val chapterResponse =
            airRemoteRepository.getAirCurrent(city, BuildConfig.API_KEY)) {
            is ResultCoroutine.Success -> {
                _airCurrent.postValue(chapterResponse.data.data[0])
            }
            is ResultCoroutine.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }
}
