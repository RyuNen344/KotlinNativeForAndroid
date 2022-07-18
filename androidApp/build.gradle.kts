plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.ryunen344.kotlin.android.android"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            storeFile = File(projectDir.path + "/keystore/android.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isJniDebuggable = true
        }
        getByName("release") {
            isDebuggable = false
            isJniDebuggable = false
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.18.1"
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}
