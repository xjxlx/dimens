@Suppress("DSL_SCOPE_VIOLATION") plugins {
    id("com.android.library")
    id("kotlin-android")
    id("io.github.xjxlx.publish") version "1.0.0"
}

android {
    namespace = "com.apphelper.dimens"
    compileSdk = libs.versions.compileSdks.get()
        .toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get()
            .toInt()
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
}

//com.github.xjxlx
//configure<com.android.helper.plugin.PublishPluginExtension> {
//    groupId.set("com.github.xjxlx") // 默认的数据是：com.github.xjxlx
//    artifactId.set("dimens") // 默认的数据是：model的名字
//    // version.set("xxxx") // 默认的数据是：获取github上项目中推送的最后的tag
//}