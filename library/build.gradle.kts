plugins {
    alias(libs.plugins.kotlin)
    id("maven-publish")
}

// Library metadata
private val groupName = "io.github.sudarshanmhasrup"
private val artifactName = "netwareclient"
private val releaseVersion = "0.0.10-beta"
private val libraryDescription = "Netware Client is an HTTP library with purpose of making networking easier in Kotlin and Java."

group = groupName
version = releaseVersion

dependencies {
    implementation(libs.gson)
    testImplementation(libs.jupiterApi)
    testImplementation(libs.jupiterEngine)
    testImplementation(libs.junitPlatformLauncher)
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

// Publishing
publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = groupName
            artifactId = artifactName
            version = releaseVersion
        }

        repositories {
            mavenCentral()
        }
    }
}

// Build directory
layout.buildDirectory.set(file("${rootDir}/.build/library"))