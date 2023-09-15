buildscript {
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://jitpack.io") }
        gradlePluginPortal()
        google()
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        // 发布JitPack的依赖版本，【3.0+以上用1.5】，【4.1+以上用2.0】，【4.6+以上用2.1】
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}


plugins {
    `kotlin-dsl`
    id("maven-publish")
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle-api:7.4.0")
    implementation(kotlin("stdlib"))
    gradleApi()
}