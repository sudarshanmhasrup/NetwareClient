plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.java)
    alias(libs.plugins.mavenPublish)
}

group = "com.github.sudarshanmhasrup"
version = "0.0.1-alpha"

repositories {
    mavenCentral()
}

dependencies {
    api(libs.json)
    api(libs.serialization)
    testImplementation(libs.jupiter)
}

sourceSets {
    main {
        kotlin.srcDirs("src/main/")
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)

        repositories {
            mavenCentral()
            gradlePluginPortal()
        }
    }

    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.test {
    useJUnitPlatform()
}

// Publication
publishing {

    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            groupId = "com.github.sudarshanmhasrup"
            artifactId = "netwareclient"
            version = "0.0.1-alpha"
        }

        repositories {
            mavenLocal()
        }
    }
}