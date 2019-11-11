package com.sun.weatherforecats.ui.managercity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.BuildConfig
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.db.entity.City
import com.sun.weatherforecats.data.model.WeatherCurrent
import com.sun.weatherforecats.data.repository.CityLocalRepository
import com.sun.weatherforecats.data.repository.WeatherRemoteRepository
import com.sun.weatherforecats.ui.base.BaseViewModel
import com.sun.weatherforecats.utils.Constants
import kotlinx.coroutines.launch

class CityyActivityViewModel(
    private val weatherRemoteRepository: WeatherRemoteRepository,
    private val cityLocalRepository: CityLocalRepository
) : BaseViewModel() {
    private val _temperatureCurent = MutableLiveData<WeatherCurrent>()
    val temperatureCurent: LiveData<WeatherCurrent>
        get() = _temperatureCurent

    private val _city = MutableLiveData<List<City>>()
    val city: LiveData<List<City>>
        get() = _city

    init {
        getCity()
    }

    fun getTemperatureCurrent(city: String) = launch {
        when (val chapterResponse =
            weatherRemoteRepository.getWeatherCurrent(city, BuildConfig.API_KEY)) {
            is ResultCoroutine.Success -> {
                _temperatureCurent.postValue(chapterResponse.data.data[0])
            }
            is ResultCoroutine.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }

    private fun getCity() = launch {
        when (val chapterResponse =
            cityLocalRepository.getCities()) {
            is ResultCoroutine.Success -> {
                _city.postValue(chapterResponse.data)
            }
            is ResultCoroutine.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }

    fun deleteCity(city: City) = launch {
        when (val chapterResponse =
            cityLocalRepository.deleteCities(city)) {
            is ResultCoroutine.Success -> {
                _messenger.postValue(Constants.CITY_NAME)
            }
            is ResultCoroutine.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }

}