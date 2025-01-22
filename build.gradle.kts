plugins {
    alias(libs.plugins.kotlin.jvm)
    id("maven-publish")
}

group = "dev.usbharu"
version = "0.2.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly(libs.kotlinx.serialization)
    compileOnly(libs.jackson)

    testImplementation(libs.kotlinx.serialization)
    testImplementation(libs.jackson)
    testImplementation(libs.jsonld.java)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/usbharu/activity-streams-serialization")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    repositories {
        maven {
            name = "Gitea"
            url = uri("https://git.usbharu.dev/api/packages/usbharu/maven")

            credentials(HttpHeaderCredentials::class.java) {
                name = "Authorization"
                value = "Bearer " + (project.findProperty("gpr.gitea") as String? ?: System.getenv("GITEA"))
            }

            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }

    publications {
        register<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            from(components["kotlin"])
            artifact(tasks["kotlinSourcesJar"])
        }
    }
}