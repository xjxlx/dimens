plugins {
    id("com.android.library")
    id("maven-publish")
}

apply<PublishPlugin>()

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
}
