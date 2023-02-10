import dependencies.CommonDependencies

plugins {
    id(CoreLibs.android)
    id(CoreLibs.kotlin)
    id(CoreLibs.kapt)
    id(AppLibs.hiltPlugin)
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = AppConfig.applicationId + ".core.utils"

    defaultConfig {
        minSdk = AppConfig.minSdk
    }
}

dependencies {
    api(CommonDependencies.appLibs)
    kapt(CommonDependencies.appProcessors)
}