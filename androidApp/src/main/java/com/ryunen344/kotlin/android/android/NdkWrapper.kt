package com.ryunen344.kotlin.android.android

class NdkWrapper {

    init {
        System.loadLibrary("ndklib")
    }

    external fun fibonacciNative(count: Long): Long

    external fun fibonacciKNative(count: Long): Long

    fun fibonacciK(n: Long): Long {
        if (n <= 0) return 0
        if (n == 1L) return 1
        return fibonacciK(n - 2) + fibonacciK(n - 1)
    }
}
