package com.sun.weatherforecats.data.source

import com.sun.weatherforecats.coroutine.ResultCoroutines
import com.sun.weatherforecats.data.db.entity.City

interface CityDataSource {
    interface Local {
        fun getCities(): ResultCoroutines<List<City>>
        fun insertCities(city: City): ResultCoroutines<City>
        fun deleteCities(city: City): ResultCoroutines<City>
    }
}
