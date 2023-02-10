import dependencies.CommonDependencies

plugins {
    id(CoreLibs.android)
    id(CoreLibs.kotlin)
    id(CoreLibs.kapt)
    id(AppLibs.kotlinSerializationPlugin)
    id(AppLibs.hiltPlugin)
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = AppConfig.applicationId + ".artworks.data"

    defaultConfig {
        minSdk = AppConfig.minSdk
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":feature-artworks:domain:repository"))

    implementation(CommonDependencies.appLibs)
    kapt(CommonDependencies.appProcessors)

    testImplementation(CommonDependencies.testLibs)
}