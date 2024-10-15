plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
}

// Source directory
sourceSets {
    main {
        java.srcDirs("src/java")
    }
}

// Build directory
layout.buildDirectory.set(file("${rootDir}/.build/examples"))