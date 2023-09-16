plugins {
    `kotlin-dsl`
    id("maven-publish")
    kotlin("jvm") version "1.8.0"
}

repositories {
    gradlePluginPortal()
    google()
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle-api:7.4.0")
    implementation(kotlin("stdlib"))
    gradleApi()
}