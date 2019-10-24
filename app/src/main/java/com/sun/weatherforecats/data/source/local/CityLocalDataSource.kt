package com.sun.weatherforecats.data.source.local

import com.sun.weatherforecats.coroutine.ResultCoroutines
import com.sun.weatherforecats.data.db.AppDatabase
import com.sun.weatherforecats.data.db.entity.City
import com.sun.weatherforecats.data.source.CityDataSource

class CityLocalDataSource(
    private val appDatabase: AppDatabase
) : CityDataSource.Local {

    override fun getCities(): ResultCoroutines<List<City>> = try {
        ResultCoroutines.Success(appDatabase.cityDao().getAllCity())
    } catch (e: Exception) {
        ResultCoroutines.Error(e)
    }

    override fun insertCities(city: City): ResultCoroutines<City> = try {
        appDatabase.cityDao().insert(city)
        ResultCoroutines.Success(city)
    } catch (e: Exception) {
        ResultCoroutines.Error(e)
    }

    override fun deleteCities(city: City): ResultCoroutines<City> = try {
        appDatabase.cityDao().remove(city)
        ResultCoroutines.Success(city)
    } catch (e: Exception) {
        ResultCoroutines.Error(e)
    }
}
