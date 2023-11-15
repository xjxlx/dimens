@Suppress("DSL_SCOPE_VIOLATION") plugins {
    id("com.android.library")
    id("kotlin-android")
    alias(libs.plugins.io.github.xjxlx.publishing)
}

android {
    namespace = "com.android.dimens"
    compileSdk = libs.versions.compileSdks.get().toInt()

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

//com.github.xjxlx
//configure<com.android.helper.plugin.PublishPluginExtension> {
//    groupId.set("com.github.xjxlx") // 默认的数据是：com.github.xjxlx
//    artifactId.set("dimens") // 默认的数据是：model的名字
//    // version.set("xxxx") // 默认的数据是：获取github上项目中推送的最后的tag
//}