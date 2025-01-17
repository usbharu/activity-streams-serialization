plugins {
    kotlin("jvm") version "2.1.0"
}

group = "dev.usbharu.hideout"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
    compileOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}