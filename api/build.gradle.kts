plugins {

}

repositories {

}

dependencies {
    implementation(libs.springBootStarterWeb)
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