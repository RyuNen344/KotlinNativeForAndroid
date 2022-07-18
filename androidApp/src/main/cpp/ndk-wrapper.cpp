#include <jni.h>
#include <string>
#include "libshared_api.h"

long long fibonacciNative(long long x);

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

long long fibonacciNative(long long x) {
    if (x <= 0) return 0;
    if (x == 1) return 1;
    return fibonacciNative(x - 1) + fibonacciNative(x - 2);
}
