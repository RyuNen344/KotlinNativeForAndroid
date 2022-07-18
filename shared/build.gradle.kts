plugins {
    kotlin("multiplatform")
}

version = "1.0"

val debugArm32SoFolder = File(buildDir, "bin/androidNativeArm32/releaseShared")
val jniArm32Folder = File(projectDir, "../androidApp/src/main/cpp/libs/armeabi-v7a")
val debugArm64SoFolder = File(buildDir, "bin/androidNativeArm64/releaseShared")
val jniArm64Folder = File(projectDir, "../androidApp/src/main/cpp/libs/arm64-v8a")

val debugX86SoFolder = File(buildDir, "bin/androidNativeX86/releaseShared")
val jniX86Folder = File(projectDir, "../androidApp/src/main/cpp/libs/x86")
val debugX64SoFolder = File(buildDir, "bin/androidNativeX64/releaseShared")
val jniX64Folder = File(projectDir, "../androidApp/src/main/cpp/libs/x86_64")

val targets = listOf(
    debugArm32SoFolder to jniArm32Folder,
    debugArm64SoFolder to jniArm64Folder,
    debugX86SoFolder to jniX86Folder,
    debugX64SoFolder to jniX64Folder,
)

val nativeFiles = listOf("*.so", "*.h")

tasks.build {
    doFirst {
        targets.map { (_, into) -> fileTree(into.path) { include(nativeFiles) } }
                .flatten()
                .forEach { it.delete() }
    }
    doLast {
        targets.forEach { (from, into) ->
            copy {
                from(from)
                into(into)
                include(nativeFiles)
            }
        }
    }
}

tasks.clean {
    doLast {
        targets.map { (_, into) -> fileTree(into.path) { include("*.so", "*.h") } }
                .flatten()
                .forEach { it.delete() }
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
