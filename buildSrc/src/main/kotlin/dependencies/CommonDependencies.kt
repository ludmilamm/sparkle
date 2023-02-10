package dependencies

import AndroidTestLibs
import AppLibs
import TestLibs

object CommonDependencies {

    val appLibs = listOf(
        AppLibs.coreKtx,
        AppLibs.hilt,
        AppLibs.coroutines
    )

    val testLibs = listOf(
        TestLibs.junit,
        TestLibs.mockk,
        TestLibs.coroutines
    )

    val androidTestLibs = listOf(
        AndroidTestLibs.androidJunit,
        AndroidTestLibs.espresso,
        AndroidTestLibs.hilt
    )

    val debugLibs = listOf<String>()

    val appProcessors = listOf(
        AppLibs.hiltCompiler
    )

    val androidTestProcessors = listOf(
        AndroidTestLibs.hiltCompiler
    )
}