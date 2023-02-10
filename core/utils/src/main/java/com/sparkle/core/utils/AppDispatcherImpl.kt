package com.sparkle.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

internal class AppDispatcherImpl @Inject constructor() : AppDispatcher {

    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}