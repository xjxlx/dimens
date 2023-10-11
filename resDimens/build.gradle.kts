plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")

//    id("io.github.xjxlx.publish")
}

//apply<com.android.helper.plugin.PublishPlugin>()

group = "com.github.xjxlx"
version = "1.0.0"

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

    publishing {
        singleVariant("release")
    }
}

afterEvaluate {// 在所有的配置都完成之后执行
    publishing { // 发布配置
        publications {
            register<MavenPublication>("release") {// 注册一个名字为 release 的发布内容
                groupId = "com.github.xjxlx"
                artifactId = "dimens"  // 插件名称
                version = "1.0.1"  // 版本号

                // 从当前 module 的 release 包中发布
                from(components["release"])
            }
        }
    }
}