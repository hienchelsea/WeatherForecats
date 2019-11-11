package com.sun.weatherforecats.ui.temperature.temperaturedaily

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.data.model.WeatherDaily
import com.sun.weatherforecats.ui.base.BaseViewModel

class TemperatureDailyDetailViewModel : BaseViewModel() {
    private val _temperatureDaily = MutableLiveData<WeatherDaily>()
    val temperatureDaily: LiveData<WeatherDaily>
        get() = _temperatureDaily

    fun getTemperatureDaily(weatherCurrent: WeatherDaily) {
        _temperatureDaily.postValue(weatherCurrent)
    }
}
