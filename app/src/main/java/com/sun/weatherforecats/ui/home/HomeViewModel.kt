package com.sun.weatherforecats.ui.home

import android.location.Geocoder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.BuildConfig
import com.sun.weatherforecats.coroutine.ResultCoroutines
import com.sun.weatherforecats.data.model.AirCurrent
import com.sun.weatherforecats.data.model.AirHourly
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.data.model.WeatherHourly
import com.sun.weatherforecats.data.repository.AirRemoteRepository
import com.sun.weatherforecats.data.repository.WeatherRemoteRepository
import com.sun.weatherforecats.ui.base.BaseViewModel
import com.sun.weatherforecats.utils.Constants
import kotlinx.coroutines.launch

class HomeViewModel(
    private val geocoder: Geocoder,
    private val weatherRemoteRepository: WeatherRemoteRepository,
    private val airRemoteRepository: AirRemoteRepository
) : BaseViewModel() {

    private val _nameCity = MutableLiveData<String>()
    val nameCity: LiveData<String>
        get() = _nameCity

    private val _temperatureCurrent = MutableLiveData<WeatherCurrent>()
    val temperatureCurrent: LiveData<WeatherCurrent>
        get() = _temperatureCurrent

    private val _temperatureHourly = MutableLiveData<List<WeatherHourly>>()
    val temperatureHourly: LiveData<List<WeatherHourly>>
        get() = _temperatureHourly

    private val _airCurrent = MutableLiveData<AirCurrent>()
    val airCurrent: LiveData<AirCurrent>
        get() = _airCurrent

    private val _airHourly = MutableLiveData<List<AirHourly>>()
    val airHourly: LiveData<List<AirHourly>>
        get() = _airHourly

    fun setNameCity(lat: Double, lon: Double) {
        try {
            val address = geocoder.getFromLocation(
                lat, lon,
                MAX_RESULTS
            )
            getWeatherCity(address[0].adminArea)

        } catch (e: Exception) {
            _messenger.postValue(e.toString())
        }
    }

    fun getWeatherCity(city: String) {
        getTemperatureCurrent(city)
        getTemperatureHourly(city)
        getAirCurrent(city)
        getAirHourly(city)
    }

    private fun getTemperatureCurrent(city: String) = launch {
        when (val chapterResponse =
            weatherRemoteRepository.getWeatherCurrent(city, BuildConfig.API_KEY)) {
            is ResultCoroutines.Success -> {
                _nameCity.postValue(city)
                _temperatureCurrent.postValue(chapterResponse.data.data[0])
            }
            is ResultCoroutines.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }

    private fun getTemperatureHourly(city: String) = launch {
        when (val chapterResponse =
            weatherRemoteRepository.getWeatherHourly(city, BuildConfig.API_KEY, HOURS)) {
            is ResultCoroutines.Success -> {
                _temperatureHourly.postValue(chapterResponse.data.data)
            }
            is ResultCoroutines.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }

    private fun getAirCurrent(city: String) = launch {
        when (val chapterResponse =
            airRemoteRepository.getAirCurrent(city, BuildConfig.API_KEY)) {
            is ResultCoroutines.Success -> {
                _airCurrent.postValue(chapterResponse.data.data[0])
            }
            is ResultCoroutines.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }

    private fun getAirHourly(city: String) = launch {
        when (val chapterResponse =
            airRemoteRepository.getAirHourly(city, BuildConfig.API_KEY, HOURS)) {
            is ResultCoroutines.Success -> {
                _airHourly.postValue(chapterResponse.data.data)
            }
            is ResultCoroutines.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }

    companion object {
        const val MAX_RESULTS = 10
        const val HOURS = 3
    }
}
