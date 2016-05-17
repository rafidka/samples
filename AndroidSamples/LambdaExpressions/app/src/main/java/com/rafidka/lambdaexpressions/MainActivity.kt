package com.rafidka.lambdaexpressions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.button) as Button
        button.setOnClickListener { }
        button.setOnClickListener { Toast.makeText(this@MainActivity.applicationContext, "Hello World", Toast.LENGTH_LONG).show() }
    }
}
