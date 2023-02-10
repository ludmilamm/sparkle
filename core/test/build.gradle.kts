import dependencies.CommonDependencies

plugins {
    id(CoreLibs.android)
    id(CoreLibs.kotlin)
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = AppConfig.applicationId + ".core.test"

    defaultConfig {
        minSdk = AppConfig.minSdk
    }
}

dependencies {
    implementation(project(":core:utils"))

    implementation(CommonDependencies.appLibs)
    api(CommonDependencies.testLibs)
}