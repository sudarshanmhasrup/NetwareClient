plugins {
    id("java")
}

dependencies {
    implementation(project(":library"))
}

// Source directory
sourceSets {
    main {
        java.srcDirs("main")
    }
}

// Build directory
layout.buildDirectory.set(file("${rootDir}/.build/examples"))