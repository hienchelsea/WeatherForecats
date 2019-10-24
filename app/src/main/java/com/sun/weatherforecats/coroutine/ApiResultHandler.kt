package com.sun.weatherforecats.coroutine

import retrofit2.Response
import java.io.IOException

open class ApiResultHandler {

    suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<T>,
        errorMessage: String
    ): ResultCoroutines<T> {
        val response = call.invoke()
        if (response.isSuccessful) {
            response.body()?.let {
                return ResultCoroutines.Success(it)
            }
        }
        return ResultCoroutines.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - $errorMessage"))
    }
}
