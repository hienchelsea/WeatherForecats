package com.sun.weatherforecats.ui.temperature.temperaturehourly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.ui.base.BaseViewModel

class TemperatureHourlyDetailViewModel : BaseViewModel() {
    private val _temperatureHourly = MutableLiveData<WeatherHourly>()
    val temperatureHourly: LiveData<WeatherHourly>
        get() = _temperatureHourly

    fun getTemperatureHourly(weatherCurrent: WeatherHourly) {
        _temperatureHourly.postValue(weatherCurrent)
    }
}
