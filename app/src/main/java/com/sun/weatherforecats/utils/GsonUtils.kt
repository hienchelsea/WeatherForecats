package com.sun.weatherforecats.utils

import com.google.gson.GsonBuilder
import com.google.gson.Gson

object GsonUtils {
    private var gson: Gson? = null

    fun getGsonParser(): Gson? {
        if (null == gson) {
            val builder = GsonBuilder()
            gson = builder.create()
        }
        return gson
    }
}