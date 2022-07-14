package com.ryunen344.kotlin.android.android

class NdkWrapper {
    init {
        System.loadLibrary("ndklib")
    }

    external fun stringFromJNI(): String
}
