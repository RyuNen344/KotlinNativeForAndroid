package com.ryunen344.kotlin.android.android

tailrec fun fibonacci(n: Long, first: Long = 0, second: Long = 1): Long {
    return if (n <= 0) {
        first
    } else {
        fibonacci(n - 1, second, first + second)
    }
}
