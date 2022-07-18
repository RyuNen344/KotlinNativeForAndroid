package com.ryunen344.kotlin.android.android

fun fibonacci(n: Long): Long {
    return if (n <= 1) {
        n
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
}
