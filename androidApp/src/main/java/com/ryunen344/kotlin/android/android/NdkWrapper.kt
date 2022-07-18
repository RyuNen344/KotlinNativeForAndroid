package com.ryunen344.kotlin.android.android

class NdkWrapper {
    companion object {
        init {
            System.loadLibrary("shared")
            System.loadLibrary("ndklib")
        }
    }

    external fun fibonacciNative(count: Long): Long

    external fun fibonacciKNative(count: Long): Long

    fun fibonacciK(n: Long): Long {
        return if (n <= 1) {
            n
        } else {
            fibonacciK(n - 2) + fibonacciK(n - 1)
        }
    }
}
