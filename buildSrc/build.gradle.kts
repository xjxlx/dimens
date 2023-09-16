plugins {
    `kotlin-dsl`
    id("maven-publish")
    kotlin("jvm") version "1.6.21"
}

//group = "com.github.jitpack"
//version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()
    google()
}

//buildscript {
//    dependencies {
//        // 发布JitPack的依赖版本，【3.0+以上用1.5】，【4.1+以上用2.0】，【4.6+以上用2.1】
//        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
//    }
//}

dependencies {
    implementation("com.android.tools.build:gradle-api:7.4.0")
    implementation(kotlin("stdlib"))
    implementation(gradleApi())
}