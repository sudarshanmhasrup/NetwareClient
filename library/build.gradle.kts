plugins {

}

repositories {
    mavenCentral()
}

dependencies {

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