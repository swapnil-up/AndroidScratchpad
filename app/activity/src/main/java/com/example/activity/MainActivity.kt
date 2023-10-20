package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var activity2Button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity2Button=findViewById(R.id.activity2button)
        activity2Button.setOnClickListener(){
            Intent(this,MainActivity2::class.java).also {
                startActivity(it)
            }
        }
    }

}