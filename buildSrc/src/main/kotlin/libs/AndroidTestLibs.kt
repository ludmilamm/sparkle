object AndroidTestLibs {
    const val androidJunit = "androidx.test.ext:junit:${AndroidTestLibsVersions.androidJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${AndroidTestLibsVersions.espresso}"
    const val runner = "androidx.test.runner.AndroidJUnitRunner"
    const val hilt = "com.google.dagger:hilt-android-testing:${AppLibsVersions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${AppLibsVersions.hilt}"
}

object AndroidTestLibsVersions {
    const val androidJunit = "1.1.5"
    const val espresso = "3.5.1"
}