package com.sun.weatherforecats.ui.air.airnow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.data.model.AirCurrent
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.ui.base.BaseViewModel

class AirNowDetailViewModel : BaseViewModel() {
    private val _temperatureCurrent = MutableLiveData<WeatherCurrent>()
    val temperatureCurrent: LiveData<WeatherCurrent>
        get() = _temperatureCurrent

    private val _airCurrent = MutableLiveData<AirCurrent>()
    val airCurrent: LiveData<AirCurrent>
        get() = _airCurrent

    fun getTemperatureCurrent(weatherCurrent: WeatherCurrent) {
        _temperatureCurrent.postValue(weatherCurrent)
    }

    fun getAirCurrent(airCurrent: AirCurrent) {
        _airCurrent.postValue(airCurrent)

    }
}
