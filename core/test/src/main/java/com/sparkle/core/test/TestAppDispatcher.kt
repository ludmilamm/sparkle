package com.sparkle.core.test

import com.sparkle.core.utils.AppDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class TestAppDispatcher : AppDispatcher {
    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.Main
}