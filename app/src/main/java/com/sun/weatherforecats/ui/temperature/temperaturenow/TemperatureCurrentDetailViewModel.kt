package com.sun.weatherforecats.ui.temperature.temperaturenow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.ui.base.BaseViewModel

class TemperatureCurrentDetailViewModel : BaseViewModel() {
    private val _temperatureCurrent = MutableLiveData<WeatherCurrent>()
    val temperatureCurrent: LiveData<WeatherCurrent>
        get() = _temperatureCurrent

     fun getTemperatureCurrent(weatherCurrent: WeatherCurrent) {
        _temperatureCurrent.postValue(weatherCurrent)
    }
}
