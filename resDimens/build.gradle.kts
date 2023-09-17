plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
}

group = "com.github.jitpack"
version = "1.0"

android {
    namespace = "com.apphelper.dimens"
    compileSdk = (Config.compileSdk)

    defaultConfig {
        minSdk = Config.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

afterEvaluate {
    publishing { // 发布配置
        publications {// 发布内容
            create<MavenPublication>("release") {// 注册一个名字为 release 的发布内容
                // 从当前 module 的 release 包中发布
                from(components["release"])
                groupId = "com.android.helper"
                artifactId = getModelNameForNamespace() // 插件名称
                version = latestGitTag().ifEmpty { Config.versionName } // 版本号
            }
        }
    }
}

/**
 * 获取model的name
 */
fun getModelNameForNamespace(): String {
    var result = "default"
    android.namespace?.let {
        if (it.contains(".")) {
            result = it.split(".")
                .reversed()
                .first()
        }
    }
    return result
}

/**
 * 获取 git 仓库中最新的 tag作为版本号
 */
fun latestGitTag(): String {
    val process = ProcessBuilder("git", "describe", "--tags", "--abbrev=0").start()
    return process.inputStream.bufferedReader()
        .use { bufferedReader ->
            bufferedReader.readText()
                .trim()
        }
}
