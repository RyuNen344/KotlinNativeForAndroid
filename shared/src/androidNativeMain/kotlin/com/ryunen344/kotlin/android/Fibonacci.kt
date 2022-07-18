package com.ryunen344.kotlin.android

fun fibonacci(n: Long): Long {
    if (n <= 0) return 0
    if (n == 1L) return 1
    return fibonacci(n - 2) + fibonacci(n - 1)
}

