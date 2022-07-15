plugins {
    kotlin("multiplatform")
}

version = "1.0"

tasks.build {
    val debugArm32SoFolder = File(buildDir, "bin/androidNativeArm32/debugShared")
    val jniArm32Folder = File(projectDir, "../androidApp/src/main/cpp/libs/armeabi-v7a")
    val debugArm64SoFolder = File(buildDir, "bin/androidNativeArm64/debugShared")
    val jniArm64Folder = File(projectDir, "../androidApp/src/main/cpp/libs/arm64-v8a")

    val debugX86SoFolder = File(buildDir, "bin/androidNativeX86/debugShared")
    val jniX86Folder = File(projectDir, "../androidApp/src/main/cpp/libs/x86")
    val debugX64SoFolder = File(buildDir, "bin/androidNativeX64/debugShared")
    val jniX64Folder = File(projectDir, "../androidApp/src/main/cpp/libs/x86_64")

    doLast {
        copy {
            from(debugArm32SoFolder)
            into(jniArm32Folder)
            include("*.so", "*.h")
        }
        copy {
            from(debugArm64SoFolder)
            into(jniArm64Folder)
            include("*.so", "*.h")
        }
        copy {
            from(debugX86SoFolder)
            into(jniX86Folder)
            include("*.so", "*.h")
        }
        copy {
            from(debugX64SoFolder)
            into(jniX64Folder)
            include("*.so", "*.h")
        }
    }
}

kotlin {
    // :androidAppが:sharedのビルドに依存するようにjvmも定義
    // :androidApp側の定義不足なのでちょっと動いてない
    jvm()
    listOf(
        androidNativeX86(),
        androidNativeX64(),
        androidNativeArm32(),
        androidNativeArm64()
    ).forEach {
        it.binaries.sharedLib()
    }

    sourceSets {
        val androidNativeX86Main by getting
        val androidNativeX64Main by getting
        val androidNativeArm32Main by getting
        val androidNativeArm64Main by getting
        val androidNativeMain by creating {
            androidNativeX86Main.dependsOn(this)
            androidNativeX64Main.dependsOn(this)
            androidNativeArm32Main.dependsOn(this)
            androidNativeArm64Main.dependsOn(this)
        }
    }
}
