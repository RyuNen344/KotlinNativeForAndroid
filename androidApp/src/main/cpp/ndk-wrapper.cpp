#include <jni.h>
#include <string>
#include "libshared_api.h"

long long int fibonacciNative(long long x);

extern "C" JNIEXPORT jstring JNICALL
Java_com_ryunen344_kotlin_android_android_NdkWrapper_stringFromJNI(
        JNIEnv *env,
        jobject) {
    libshared_ExportedSymbols *symbols = libshared_symbols();
    libshared_kref_com_ryunen344_kotlin_android_Platform platform = libshared_kref_com_ryunen344_kotlin_android_Platform();
    std::string hello = symbols->kotlin.root.com.ryunen344.kotlin.android.Platform.getPlatform(
            platform);
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jlong JNICALL
Java_com_ryunen344_kotlin_android_android_NdkWrapper_fibonacciNative(
        JNIEnv *env,
        jobject,
        jlong count) {
    return fibonacciNative(count);
}

extern "C" JNIEXPORT jlong JNICALL
Java_com_ryunen344_kotlin_android_android_NdkWrapper_fibonacciKNative(
        JNIEnv *env,
        jobject,
        jlong count) {
    libshared_ExportedSymbols *symbols = libshared_symbols();
    return symbols->kotlin.root.com.ryunen344.kotlin.android.fibonacci(count);
}

long long int fibonacciNative(long long x) {
    if (x <= 1) {
        return x;
    } else {
        return fibonacciNative(x - 1) + fibonacciNative(x - 2);
    }
}
