import dependencies.CommonDependencies
import dependencies.PresentationDependencies

plugins {
    id(CoreLibs.android)
    id(CoreLibs.kotlin)
    id(CoreLibs.kapt)
    id(AppLibs.hiltPlugin)
    id(AppLibs.kotlinParcelizePlugin)
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = AppConfig.applicationId + ".artworks"

    defaultConfig {
        minSdk = AppConfig.minSdk
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppLibsVersions.composeCompiler
    }
}

dependencies {
    implementation(project(":feature-artworks:domain"))
    implementation(project(":core:ui"))
    implementation(project(":core:utils"))

    implementation(platform(AppLibs.composeBOM))
    implementation(CommonDependencies.appLibs + PresentationDependencies.appLibs)
    kapt(CommonDependencies.appProcessors)
    implementation(AppLibs.pagingCompose)

    debugImplementation(PresentationDependencies.debugLibs)

    testImplementation(project(":core:test"))
}