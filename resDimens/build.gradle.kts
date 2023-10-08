
plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
    id("io.github.xjxlx.publish") version "1.4.4"
}

group = "com.github.xjxlx"
version = "1.0"

android {
    namespace = "com.apphelper.dimens"
    compileSdk = 30

    defaultConfig {
        minSdk = 24
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

//    publishing {
//        singleVariant("release") {
//            // withSourcesJar()
//            //  withJavadocJar()
//        }
//    }
}

//afterEvaluate {// 在所有的配置都完成之后执行
//    publishing { // 发布配置
//        publications {
//            register<MavenPublication>("release") {// 注册一个名字为 release 的发布内容
//                groupId = "com.github.xjxlx"
//                artifactId = getModelNameForNamespace()  // 插件名称
//                version = latestGitTag().ifEmpty { "master-SNAPSHOT" } // 版本号
//
//                // 从当前 module 的 release 包中发布
//                from(components["release"])
//            }
//        }
//    }
//}

///**
// * 获取model的name
// */
//fun getModelNameForNamespace(): String {
//    var result = "default"
//    android.namespace?.let {
//        if (it.contains(".")) {
//            result = it.split(".")
//                .reversed()
//                .first()
//        }
//    }
//    return result
//}
//
///**
// * 获取 git 仓库中最新的 tag作为版本号
// */
//fun latestGitTag(): String {
//    val process = ProcessBuilder("git", "describe", "--tags", "--abbrev=0").start()
//    return process.inputStream.bufferedReader()
//        .use { bufferedReader ->
//            bufferedReader.readText()
//                .trim()
//        }
//}

apply<com.android.helper.plugin.PublishPlugin>()

//configure<com.android.helper.plugin.PublishPluginExtension> {
//    groupId.set("com.github.xjxlx")
//    artifactId.set("dimens")
//    version.set("v2.0.0.8")
//}