package com.sun.weatherforecats.data.repository

import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.db.entity.City
import com.sun.weatherforecats.data.source.CityDataSource

class CityLocalRepository(
    private val cityDataSource: CityDataSource.Local
) : CityDataSource.Local {
    override fun getCities(): ResultCoroutine<List<City>> = cityDataSource.getCities()

    override fun insertCities(city: City): ResultCoroutine<City> = cityDataSource.insertCities(city)

    override fun deleteCities(city: City): ResultCoroutine<City> = cityDataSource.deleteCities(city)
}
