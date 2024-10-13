plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.20"
}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}