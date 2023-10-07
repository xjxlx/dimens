pluginManagement {
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        gradlePluginPortal()
        google()
        mavenLocal()
        mavenCentral()
        maven {
            setUrl("https://jitpack.io")
            content {
                includeGroup("com.github.xjxlx")
            }
        }
    }

//    // 配置本地插件
//    plugins {
//        id("io.github.xjxlx.publish") version "1.0.9"
//    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    //    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        google()
        mavenLocal()
        mavenCentral()
        maven {
            setUrl("https://jitpack.io")
            content {
                includeGroup("com.github.xjxlx")
            }
        }
    }
}

//dependencies {
//    implementation 'com.github.User:Repo:Version'
//}

rootProject.name = "dimens"
include(":resDimens")
include(":app")

