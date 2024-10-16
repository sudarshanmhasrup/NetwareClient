// Top level gradle build file which applies Kotlin JVM plugin to all subjects
plugins {
    alias(libs.plugins.kotlin)
}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        implementation(kotlin("stdlib"))
    }
}

layout.buildDirectory.set(file("${rootDir}/.build/netwareclient"))