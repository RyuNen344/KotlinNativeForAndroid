plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

version = "1.0"

kotlin {
    android()
    androidNativeX64()
    androidNativeArm64()

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidNativeX64Main by getting
        val androidNativeArm64Main by getting
        val androidNativeMain by creating {
            dependsOn(commonMain)
            androidNativeX64Main.dependsOn(this)
            androidNativeArm64Main.dependsOn(this)
        }
        val androidNativeX64Test by getting
        val androidNativeArm64Test by getting
        val androidNativeTest by creating {
            dependsOn(commonTest)
            androidNativeX64Test.dependsOn(this)
            androidNativeArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 28
        targetSdk = 32
    }
}
