package com.example.homework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_details.*

class ShowDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)
        // To avoid application crash check intent has data or not
        if(intent.hasExtra("image") && intent.hasExtra("name")&& intent.hasExtra("recipe")){
            var ig =intent.getIntExtra("image",0)
            var t1 = intent.getStringExtra("name")
            var t2 = intent.getStringExtra("recipe")
            textView3.text = t1.toString()
            textView4.text = t2.toString()
            imageView2.setImageResource(ig)
        }
    }
}