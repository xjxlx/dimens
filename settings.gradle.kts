pluginManagement {
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://plugins.gradle.org/m2/") }

        gradlePluginPortal()
        google()
        mavenLocal()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://plugins.gradle.org/m2/") }

        google()
        mavenLocal()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }

        maven {
            setUrl("https://maven.aliyun.com/repository/public")
        }
        maven {
            credentials {
                username = "6123a7974e5db15d52e7a9d8"
                password = "HsDc[dqcDfda"
            }
            setUrl("https://packages.aliyun.com/maven/repository/2131155-release-wH01IT/")
        }
    }
    versionCatalogs {
        create("libs") {
            from("com.android:catalogs:1.0.0")
        }
    }
}

rootProject.name = "dimens"
include(":resDimens")
include(":app")

