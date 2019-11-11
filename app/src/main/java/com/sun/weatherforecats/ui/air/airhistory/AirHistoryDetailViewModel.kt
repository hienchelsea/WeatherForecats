package com.sun.weatherforecats.ui.air.airhistory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.weatherforecats.data.model.AirHistory
import com.sun.weatherforecats.ui.base.BaseViewModel

class AirHistoryDetailViewModel : BaseViewModel() {
    private val _airHistory = MutableLiveData<AirHistory>()
    val airHistory: LiveData<AirHistory>
        get() = _airHistory

    fun getAirHistory(airHistory: AirHistory) {
        _airHistory.postValue(airHistory)

    }
}
