package com.sun.weatherforecats.data.db.dao

import androidx.room.*
import com.sun.weatherforecats.data.db.entity.City

@Dao
interface CityDao {

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllCity(): List<City>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(city: City): Long

    @Delete
    fun remove(city: City)

    companion object {
        private const val TABLE_NAME = City.TABLE_NAME
    }
}
