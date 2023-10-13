plugins {
    id("com.android.library")
    id("kotlin-android")
    id("io.github.xjxlx.publish")
}

apply<com.android.helper.plugin.PublishPlugin>()

//group = "com.github.jitpack"
//version = "1.0"

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
//        singleVariant("release")
//    }
}