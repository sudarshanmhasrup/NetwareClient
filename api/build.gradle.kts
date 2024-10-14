plugins {
    alias(libs.plugins.kotlinSpring)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.springBootStarterWeb)
    implementation(project(":library"))
    testImplementation(libs.jupiterApi)
    testImplementation(libs.jupiterEngine)
    testImplementation(libs.junitPlatformLauncher)
}

// Source directory
sourceSets {
    main {
        kotlin.srcDirs("src/main/kotlin")
    }
    test {
        kotlin.srcDirs("src/test")
    }
}

tasks.test {
    useJUnitPlatform()
}

// Build directory
layout.buildDirectory.set(file("${rootDir}/.build/api"))