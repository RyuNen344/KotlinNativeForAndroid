package com.ryunen344.kotlin.android.android

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val count = 30L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ndkWrapper = NdkWrapper()

        findViewById<Button>(R.id.button_pure_native)?.let {
            it.setOnClickListener {
                lifecycleScope.launch(Dispatchers.Default) {
                    val result: Long
                    val pureNativeMills = measureTimeMillis {
                        result = ndkWrapper.fibonacciNative(count)
                    }
                    Log.wtf(TAG, "native $result $pureNativeMills ms")
                }
            }
        }

        findViewById<Button>(R.id.button_kotlin_native)?.let {
            it.setOnClickListener {
                lifecycleScope.launch(Dispatchers.Default) {
                    val result: Long
                    val kNativeMills = measureTimeMillis {
                        result = ndkWrapper.fibonacciKNative(count)
                    }
                    Log.wtf(TAG, "kotlin native $result $kNativeMills ms")
                }
            }
        }

        findViewById<Button>(R.id.button_kotlin)?.let {
            it.setOnClickListener {
                lifecycleScope.launch(Dispatchers.Default) {
                    val result: Long
                    val kMills = measureTimeMillis {
                        result = ndkWrapper.fibonacciK(count)
                    }
                    Log.wtf(TAG, "kotlin $result $kMills ms")
                }
            }
        }
    }
}
