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

rootProject.name = "Android Scratchpad"
include(":app")
include(":app:alertdialogs")
include(":app:toasts")
include(":app:activity")
include(":app:luckynumber")
include(":app:music")
