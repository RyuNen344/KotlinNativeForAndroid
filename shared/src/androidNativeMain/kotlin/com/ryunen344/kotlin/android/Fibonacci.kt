package com.ryunen344.kotlin.android

fun fibonacci(n: Long): Long {
    return if (n <= 1) {
        n
    } else {
        fibonacci(n - 2) + fibonacci(n - 1)
    }
}

