import dependencies.CommonDependencies
import dependencies.PresentationDependencies

plugins {
    id(CoreLibs.android)
    id(CoreLibs.kotlin)
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = AppConfig.applicationId + ".core.ui"

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
    implementation(platform(AppLibs.composeBOM))
    implementation(CommonDependencies.appLibs + PresentationDependencies.appLibs)
    debugImplementation(PresentationDependencies.debugLibs)
}