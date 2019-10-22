package com.sun.weatherforecats.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {
    private val parentJob = Job()

    override val coroutineContext: CoroutineContext = parentJob + Dispatchers.Default

    fun cancelAllRequests() = coroutineContext.cancel()
}
