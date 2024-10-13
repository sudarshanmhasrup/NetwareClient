rootProject.name = "NetwareClient"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.jvm") version "2.0.20"
    }
}

include(":library")