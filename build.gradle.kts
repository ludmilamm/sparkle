// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(CoreLibs.application) version CoreVersions.android apply false
    id(CoreLibs.android) version CoreVersions.android apply false
    id(CoreLibs.kotlin) version CoreVersions.kotlin apply false
    id(AppLibs.hiltPlugin) version AppLibsVersions.hilt apply false
    id(AppLibs.kotlinSerializationPlugin) version CoreVersions.kotlin apply false
}
