package com.ryunen344.kotlin.android.android

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    private val count: Long = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ndkWrapper = NdkWrapper()

        findViewById<Button>(R.id.button_pure_native)?.let {
            it.setOnClickListener {
                val pureNativeMills = measureNanoTime {
                    ndkWrapper.fibonacciNative(count)
                }
                println("$pureNativeMills ns")
            }
        }

        findViewById<Button>(R.id.button_kotlin_native)?.let {
            it.setOnClickListener {
                val kNativeMills = measureNanoTime {
                    ndkWrapper.fibonacciKNative(count)
                }
                println("$kNativeMills ns")
            }
        }

        findViewById<Button>(R.id.button_kotlin)?.let {
            it.setOnClickListener {
                val kMills = measureNanoTime {
                    fibonacci(count)
                }
                println("$kMills ns")
            }
        }
    }
}
