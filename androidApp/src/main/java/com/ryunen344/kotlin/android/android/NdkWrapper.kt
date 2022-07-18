package com.ryunen344.kotlin.android.android

class NdkWrapper {
    init {
        System.loadLibrary("ndklib")
    }

    external fun stringFromJNI(): String

    external fun fibonacciNative(count: Long): Long

    external fun fibonacciKNative(count: Long): Long
}
