#include <jni.h>
#include <string>
#include "libshared_api.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_ryunen344_kotlin_android_android_NdkWrapper_stringFromJNI(
        JNIEnv *env,
        jobject) {
    libshared_ExportedSymbols *symbols = libshared_symbols();
    libshared_kref_com_ryunen344_kotlin_android_Platform platform = libshared_kref_com_ryunen344_kotlin_android_Platform();
    std::string hello = symbols->kotlin.root.com.ryunen344.kotlin.android.Platform.getPlatform(platform);
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jlong JNICALL
Java_com_ryunen344_kotlin_android_android_NdkWrapper_argumentTest(
        JNIEnv *env,
        jobject,
        jint count) {
    libshared_ExportedSymbols *symbols = libshared_symbols();
    libshared_kref_com_ryunen344_kotlin_android_Fibonacci fibonacci = libshared_kref_com_ryunen344_kotlin_android_Fibonacci();
    return symbols->kotlin.root.com.ryunen344.kotlin.android.Fibonacci.invoke(fibonacci, count);
}
