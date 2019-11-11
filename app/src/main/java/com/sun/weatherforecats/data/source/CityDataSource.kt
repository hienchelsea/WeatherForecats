package com.sun.weatherforecats.data.source

import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.db.entity.City

interface CityDataSource {
    interface Local {
        fun getCities(): ResultCoroutine<List<City>>
        fun insertCities(city: City): ResultCoroutine<City>
        fun deleteCities(city: City): ResultCoroutine<City>
    }
}
