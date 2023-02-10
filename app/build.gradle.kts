import dependencies.CommonDependencies
import dependencies.PresentationDependencies

plugins {
    id(CoreLibs.application)
    id(CoreLibs.kotlin)
    id(CoreLibs.kapt)
    id(AppLibs.hiltPlugin)
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AndroidTestLibs.runner
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppLibsVersions.composeCompiler
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":core:utils"))
    implementation(project(":feature-artworks"))
    implementation(project(":feature-artworks:data"))

    implementation(platform(AppLibs.composeBOM))

    implementation(CommonDependencies.appLibs + PresentationDependencies.appLibs)
    debugImplementation(PresentationDependencies.debugLibs)
    kapt(CommonDependencies.appProcessors)

    androidTestImplementation(CommonDependencies.androidTestLibs)
    kaptAndroidTest(CommonDependencies.androidTestProcessors)

    testImplementation(CommonDependencies.testLibs)
}

kapt {
    correctErrorTypes = true
}