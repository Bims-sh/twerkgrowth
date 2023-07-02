import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.8.21"
    id("xyz.jpenilla.run-paper") version "2.1.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
    maven { url = uri("https://oss.sonatype.org/content/groups/public/") }
    maven { url = uri("https://repo.maven.apache.org/maven2/") }
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0-RC")
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    implementation("net.kyori:adventure-api:4.14.0")
}

group = "dev.dasischbims"
version = "1.0"
description = "Twerk Growth"
java.sourceCompatibility = JavaVersion.VERSION_17

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks {
    shadowJar {
        archiveClassifier.set("shaded")
    }

    runServer {
        minecraftVersion("1.20.1")
        dependsOn(shadowJar)
        pluginJars(shadowJar.get().archiveFile)
    }
}