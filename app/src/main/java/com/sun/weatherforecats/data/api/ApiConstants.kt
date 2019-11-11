package com.sun.weatherforecats.data.api

internal const val PATH_WEATHER_CURRENT = "current"
internal const val PATH_WEATHER_HOURLY = "forecast/hourly"
internal const val PATH_WEATHER_DAILY = "forecast/daily"
internal const val PATH_AIR_CURRENT = "current/airquality"
internal const val PATH_AIR_HOURLY = "forecast/airquality"
internal const val PATH_AIR_HISTORY = "history/airquality"
internal const val QUERY_CITY = "city"
internal const val QUERY_KEY = "key"
internal const val QUERY_HOURS = "hours"
internal const val QUERY_DAYS = "days"

object ApiConstants {
    const val API_BASE_URL = "https://api.weatherbit.io/v2.0/"
    const val API_BASE_URL_IMAGE = "https://www.weatherbit.io/static/img/icons/"
}
