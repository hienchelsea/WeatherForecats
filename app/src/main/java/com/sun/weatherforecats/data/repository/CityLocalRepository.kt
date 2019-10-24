package com.sun.weatherforecats.data.repository

import com.sun.weatherforecats.coroutine.ResultCoroutines
import com.sun.weatherforecats.data.db.entity.City
import com.sun.weatherforecats.data.source.CityDataSource

class CityLocalRepository(
    private val cityDataSource: CityDataSource.Local
) : CityDataSource.Local {
    override fun getCities(): ResultCoroutines<List<City>> = cityDataSource.getCities()

    override fun insertCities(city: City): ResultCoroutines<City> = cityDataSource.insertCities(city)

    override fun deleteCities(city: City): ResultCoroutines<City> = cityDataSource.deleteCities(city)
}
