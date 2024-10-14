plugins {
    alias(libs.plugins.kotlinSpring)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.springBootStarterWeb)
    testImplementation(libs.jupiterApi)
    testImplementation(libs.jupiterEngine)
}

// Source directory
sourceSets {
    main {
        kotlin.srcDirs("src/main")
    }
    test {
        kotlin.srcDirs("src/test")
    }
}

tasks.test {
    useJUnitPlatform()
}