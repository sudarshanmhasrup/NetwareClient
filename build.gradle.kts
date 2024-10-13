plugins {
    alias(libs.plugins.kotlin)
}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}