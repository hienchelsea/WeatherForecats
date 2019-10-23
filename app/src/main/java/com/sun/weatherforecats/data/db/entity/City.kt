package com.sun.weatherforecats.data.db.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = City.TABLE_NAME)

data class City(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = CITY_ID)
    val id: Long = 0L,
    @NonNull
    @ColumnInfo(name = CITY_NAME)
    val name: String
) {
    companion object {
        const val TABLE_NAME = "city"
        const val CITY_ID = "city_id"
        const val CITY_NAME = "city_name"
    }
}
