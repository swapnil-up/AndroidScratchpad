package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var closeActivity2:Button
    private lateinit var textView2:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name=intent.getStringExtra("EXTRA_NAME")
        val age=intent.getIntExtra("EXTRA_AGE",0)
        val person=intent.getSerializableExtra("EXTRA_PERSON") as PersonData
        val customText="$name is $age old"

        val text3:TextView=findViewById(R.id.text3)
        text3.text=person.toString()

        textView2=findViewById(R.id.textView2)
        textView2.text = customText


        closeActivity2=findViewById(R.id.closeActivity2)
        closeActivity2.setOnClickListener(){
            finish()
        }
    }
}