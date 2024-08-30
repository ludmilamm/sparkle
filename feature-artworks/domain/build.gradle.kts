import dependencies.CommonDependencies

plugins {
    id(CoreLibs.android)
    id(CoreLibs.kotlin)
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = AppConfig.applicationId + ".artworks.domain"

    defaultConfig {
        minSdk = AppConfig.minSdk
    }
}

dependencies {
    api(project(":feature-artworks:domain:repository"))

    implementation(CommonDependencies.appLibs)
    implementation(AppLibs.paging)

    testImplementation(CommonDependencies.testLibs)
}