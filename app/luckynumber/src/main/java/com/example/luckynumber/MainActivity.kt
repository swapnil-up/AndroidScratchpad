package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val LuckyNumber:EditText=findViewById(R.id.LuckyNumber)
        val LuckyButton:Button=findViewById(R.id.LuckyButton)

        LuckyButton.setOnClickListener(){
            Intent(this, LuckyNumberActivity::class.java).also {
                it.putExtra("EXTRA_NAME",LuckyNumber.text.toString())
                startActivity(it)
            }
        }
    }
}