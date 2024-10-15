repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
}

// Source directory
sourceSets {
    main {
        java.srcDirs("main/java")
    }
}