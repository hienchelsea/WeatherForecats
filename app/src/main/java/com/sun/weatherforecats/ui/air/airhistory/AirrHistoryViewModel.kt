package com.sun.weatherforecats.ui.air.airhistory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.BuildConfig
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.model.AirHistory
import com.sun.weatherforecats.data.repository.AirRemoteRepository
import com.sun.weatherforecats.ui.base.BaseViewModel
import com.sun.weatherforecats.utils.Constants
import kotlinx.coroutines.launch

class AirrHistoryViewModel(private val airRemoteRepository: AirRemoteRepository) : BaseViewModel() {
    private val _airHistory = MutableLiveData<List<AirHistory>>()
    val airHistory: LiveData<List<AirHistory>>
        get() = _airHistory


    fun getAirHistory(city: String) = launch {
        when (val chapterResponse =
            airRemoteRepository.getAirHistory(city, BuildConfig.API_KEY, 24)) {
            is ResultCoroutine.Success -> {
                _airHistory.postValue(chapterResponse.data.data)
            }
            is ResultCoroutine.Error -> {
                _messenger.postValue(Constants.ERROR_MESSAGE)
            }
        }
    }
}
