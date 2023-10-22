plugins {
    id("com.android.library")
    id("kotlin-android")
    id("io.github.xjxlx.publish")
    id("io.github.xjxlx.catalog")
}

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
}

configure<com.android.helper.plugin.PublishPluginExtension> {
    version.set("1.0.0") // 默认的数据是：获取github上项目中推送的最后的tag
}