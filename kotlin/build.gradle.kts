plugins {
    alias(libs.plugins.kotlin)
}

dependencies {
    implementation(project(":library"))
}

sourceSets {
    main {
        kotlin.srcDirs("main")
    }
}

// Build directory
layout.buildDirectory.set(file("${rootDir}/.build/kotlin"))