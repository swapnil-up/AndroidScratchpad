package com.example.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private lateinit var activity2Button: Button
    private lateinit var ageField:EditText
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity2Button=findViewById(R.id.activity2button)
        activity2Button.setOnClickListener(){
            var nameField:EditText=findViewById(R.id.NameField)
            ageField=findViewById(R.id.AgeField)
            val person= PersonData(nameField.text.toString(),ageField.text.toString().toInt())
            Intent(this,MainActivity2::class.java).also {
                it.putExtra("EXTRA_NAME",nameField.text.toString())
                it.putExtra("EXTRA_AGE",ageField.text.toString().toInt())
                it.putExtra("EXTRA_PERSON",person)
                startActivity(it)
            }
        }
    }

}