package com.ryunen344.kotlin.android.android

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedWrapper = SharedWrapper()

        val tv: TextView = findViewById(R.id.text_view)

        val button = findViewById<Button>(R.id.button_run)
        button.setOnClickListener {
            println(sharedWrapper.getStringFromKotlinNative())
        }
    }
}
