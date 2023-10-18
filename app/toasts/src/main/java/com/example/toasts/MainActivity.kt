package com.example.toasts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var toastButton: Button
    private lateinit var customToastButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastButton=findViewById(R.id.toastButton)
        customToastButton=findViewById(R.id.customToastButton)

        toastButton.setOnClickListener(){
            Toast.makeText(applicationContext,"Hey there!",Toast.LENGTH_LONG).show()
        }

        customToastButton.setOnClickListener(){
            Toast(this).apply {
                duration=Toast.LENGTH_LONG
                view=layoutInflater.inflate(R.layout.customtoast,findViewById(R.id.clToast))
                show()
            }
        }

    }
}