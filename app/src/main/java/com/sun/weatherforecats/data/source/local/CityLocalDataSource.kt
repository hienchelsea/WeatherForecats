package com.sun.weatherforecats.data.source.local

import android.util.Log
import com.sun.weatherforecats.coroutine.ResultCoroutine
import com.sun.weatherforecats.data.db.AppDatabase
import com.sun.weatherforecats.data.db.entity.City
import com.sun.weatherforecats.data.source.CityDataSource

class CityLocalDataSource(
    private val appDatabase: AppDatabase
) : CityDataSource.Local {

    override fun getCities(): ResultCoroutine<List<City>> = try {
        ResultCoroutine.Success(appDatabase.cityDao().getAllCity())
    } catch (e: Exception) {
        ResultCoroutine.Error(e)
    }

    override fun insertCities(city: City): ResultCoroutine<City> = try {
        appDatabase.cityDao().insert(city)
        ResultCoroutine.Success(city)
    } catch (e: Exception) {
        ResultCoroutine.Error(e)
    }

    override fun deleteCities(city: City): ResultCoroutine<City> = try {
        appDatabase.cityDao().remove(city)
        ResultCoroutine.Success(city)
    } catch (e: Exception) {
        Log.d("Hien",e.toString())
        ResultCoroutine.Error(e)
    }
}
