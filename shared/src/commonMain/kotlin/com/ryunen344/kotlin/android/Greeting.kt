package com.ryunen344.kotlin.android

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}