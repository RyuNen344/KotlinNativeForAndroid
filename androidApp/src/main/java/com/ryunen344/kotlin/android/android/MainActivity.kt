package com.ryunen344.kotlin.android.android

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ndkWrapper = NdkWrapper()

        findViewById<Button>(R.id.button_pure_native)?.let {
            it.setOnClickListener {
                println(ndkWrapper.fibonacciNative(10))
            }
        }

        findViewById<Button>(R.id.button_kotlin_native)?.let {
            it.setOnClickListener {
                println(ndkWrapper.fibonacciKNative(10))
            }
        }

        findViewById<Button>(R.id.button_kotlin)?.let {
            it.setOnClickListener {
                println(fibonacci(10))
            }
        }
    }
}
