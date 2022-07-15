#include <jni.h>
#include <string>
#include "libshared_api.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_ryunen344_kotlin_android_android_NdkWrapper_stringFromJNI(
        JNIEnv *env,
        jobject) {
    libshared_ExportedSymbols *symbols = libshared_symbols();
    libshared_kref_com_ryunen344_kotlin_android_Platform platform = libshared_kref_com_ryunen344_kotlin_android_Platform();
    std::string hello = symbols->kotlin.root.com.ryunen344.kotlin.android.Platform.gePlatform(
            platform);
    return env->NewStringUTF(hello.c_str());
}
