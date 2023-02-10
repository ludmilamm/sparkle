pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Sparkle"

include(":app")
include(":core:data")
include(":core:ui")
include(":feature-artworks")
include(":feature-artworks:data")
include(":feature-artworks:domain")
include(":feature-artworks:domain:repository")
include(":core:utils")
include(":core:test")
