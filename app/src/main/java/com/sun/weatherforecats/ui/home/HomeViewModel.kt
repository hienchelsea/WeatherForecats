package com.sun.weatherforecats.ui.home

import android.location.Geocoder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.ui.base.BaseViewModel

class HomeViewModel(private val geocoder: Geocoder) : BaseViewModel() {

    private val _nameCity = MutableLiveData<String>()
    val nameCity: LiveData<String>
        get() = _nameCity

    fun setNameCity(lat: Double, lon: Double) {
        try {
            val address = geocoder.getFromLocation(
                lat, lon,
                MAX_RESULTS
            )
            _nameCity.postValue(address[0].adminArea)
        } catch (e: Exception) {
            _messenger.postValue(e.toString())
        }
    }

    companion object {
        const val MAX_RESULTS = 10
    }
}
