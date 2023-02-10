package com.sparkle.core.utils

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatcher {
    val dispatcher: CoroutineDispatcher
}