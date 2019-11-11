package com.sun.weatherforecats.ui.temperature.temperaturedaily

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.BuildConfig
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.model.WeatherDaily
import com.sun.weatherforecats.data.repository.WeatherRemoteRepository
import com.sun.weatherforecats.ui.base.BaseViewModel
import com.sun.weatherforecats.utils.Constants
import kotlinx.coroutines.launch

class TemperatureDailyViewModel(
    private val weatherRemoteRepository: WeatherRemoteRepository
) : BaseViewModel() {
    private val _temperatureDaily = MutableLiveData<List<WeatherDaily>>()
    val temperatureDaily: LiveData<List<WeatherDaily>>
        get() = _temperatureDaily

    fun getTemperatureDaily(city: String) = launch {
        when (val chapterResponse =
            weatherRemoteRepository.getWeatherDaily(city, BuildConfig.API_KEY, 14)) {
            is ResultCoroutine.Success -> {
                _temperatureDaily.postValue(chapterResponse.data.data)
            }
            is ResultCoroutine.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }
}
