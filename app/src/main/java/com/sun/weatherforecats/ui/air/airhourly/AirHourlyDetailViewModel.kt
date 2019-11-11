package com.sun.weatherforecats.ui.air.airhourly

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.data.model.AirHourly
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.ui.base.BaseViewModel

class AirHourlyDetailViewModel : BaseViewModel() {
    private val _temperatureHourly = MutableLiveData<WeatherHourly>()
    val temperatureHourly: LiveData<WeatherHourly>
        get() = _temperatureHourly

    private val _airHourly = MutableLiveData<AirHourly>()
    val airHourly: LiveData<AirHourly>
        get() = _airHourly

     fun getTemperatureHourly(weatherHourly: WeatherHourly) {
        _temperatureHourly.postValue(weatherHourly)
    }

     fun getAirHourly(airHourly: AirHourly) {
        _airHourly.postValue(airHourly)
    }
}
