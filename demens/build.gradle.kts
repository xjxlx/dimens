plugins {
    id("com.android.library")
    id("maven-publish")
}

group = "com.github.jitpack"
version = "1.0"

android {
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

//afterEvaluate {
//    publishing {
//        publications {
//            // Creates a Maven publication called "release".
//            release(MavenPublication) {
//                from components . release groupId = "com.github.xjxlx.dimens"// groupId 随便取，jitpack不会使用
//                artifactId = "android-example"// artifactId 随便取,jitpack不会使用
//                version = "1.3.0" // version 随便取，jitpack不会使用
//            }
//        }
//    }
//}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                // 插件id，格式：com.gitee/github.用户名
                groupId = "com.android.apphelper"
                artifactId = "dimens"// 插件名称
                version = "1.3.1"// 版本号
                from(components["release"])
            }
        }
    }
}
