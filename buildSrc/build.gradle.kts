plugins {
    `kotlin-dsl`
    id("maven-publish")
    kotlin("jvm") version "1.6.21"
}

group = "com.github.jitpack"
version = "1.0"

repositories {
    google()
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle-api:7.4.0")
    implementation(kotlin("stdlib"))
    gradleApi()
}