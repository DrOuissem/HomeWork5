package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_ex1.setOnClickListener {
            val intent = Intent(this, Exercise1::class.java)
            startActivity(intent)
        }
        bt_ex2.setOnClickListener {
            val intent = Intent(this, Exercise2::class.java)
            startActivity(intent)
        }
    }
}