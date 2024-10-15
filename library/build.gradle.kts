import java.io.FileInputStream
import java.util.Properties

plugins {
    id("maven-publish")
}

// Library metadata
private val groupName = "io.github.sudarshanmhasrup"
private val artifactName = "netwareclient"
private val releaseVersion = "1.0.0-SNAPSHOT"
private val libraryDescription = "Netware Client is an HTTP library with purpose of making networking easier in Kotlin and Java."

group = groupName
version = releaseVersion

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.gson)
    testImplementation(libs.jupiterApi)
    testImplementation(libs.jupiterEngine)
    testImplementation(libs.junitPlatformLauncher)
}

// Source and test directory
sourceSets {
    main {
        kotlin.srcDirs("src/main")
    }
    test  {
        kotlin.srcDirs("src/test")
    }
}

tasks.test {
    useJUnitPlatform()
}

// Build directory
layout.buildDirectory.set(file("${rootDir}/.build/library"))