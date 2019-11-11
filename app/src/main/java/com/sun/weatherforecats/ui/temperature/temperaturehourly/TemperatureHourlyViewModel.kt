package com.sun.weatherforecats.ui.temperature.temperaturehourly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.BuildConfig
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.data.repository.WeatherRemoteRepository
import com.sun.weatherforecats.ui.base.BaseViewModel
import com.sun.weatherforecats.utils.Constants
import kotlinx.coroutines.launch

class TemperatureHourlyViewModel(
    private val weatherRemoteRepository: WeatherRemoteRepository
) : BaseViewModel() {
    private val _temperatureHourly = MutableLiveData<List<WeatherHourly>>()
    val temperatureHourly: LiveData<List<WeatherHourly>>
        get() = _temperatureHourly

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
}
