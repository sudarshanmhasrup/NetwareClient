plugins {

}

private val groupId = "com.github.sudarshanmhasrup"
private val artifactId = "netwareclient"
private val version = "1.0.0-SNAPSHOT"

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