plugins {
    id("maven-publish")
}

// Library metadata
private val groupId = "com.github.sudarshanmhasrup"
private val artifactId = "netwareclient"
private val releaseVersion = "1.0.0-SNAPSHOT"

group = groupId
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