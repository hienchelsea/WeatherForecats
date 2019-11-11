package com.sun.weatherforecats.ui.temperature.temperaturenow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.BuildConfig
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.data.repository.WeatherRemoteRepository
import com.sun.weatherforecats.ui.base.BaseViewModel
import com.sun.weatherforecats.utils.Constants
import kotlinx.coroutines.launch

class TemperatureNowViewModel(
    private val weatherRemoteRepository: WeatherRemoteRepository
) : BaseViewModel() {
    private val _temperatureCurrent = MutableLiveData<WeatherCurrent>()
    val temperatureCurrent: LiveData<WeatherCurrent>
        get() = _temperatureCurrent


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
}
