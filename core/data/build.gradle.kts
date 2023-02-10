import dependencies.CommonDependencies
import dependencies.DataDependencies

plugins {
    id(CoreLibs.android)
    id(CoreLibs.kotlin)
    id(CoreLibs.kapt)
    id(AppLibs.kotlinSerializationPlugin)
    id(AppLibs.hiltPlugin)
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = AppConfig.applicationId + ".core.data"

    defaultConfig {
        minSdk = AppConfig.minSdk
    }
}

dependencies {
    api(CommonDependencies.appLibs + DataDependencies.appLibs)
    kapt(CommonDependencies.appProcessors)
}