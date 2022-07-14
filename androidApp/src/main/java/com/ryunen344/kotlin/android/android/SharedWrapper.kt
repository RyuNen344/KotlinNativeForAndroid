package com.ryunen344.kotlin.android.android

class SharedWrapper {

    init {
        System.loadLibrary("shared")
    }

    external fun getStringFromKotlinNative(): String
}
