package com.example.alertdialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var button1:Button
    private lateinit var button2:Button
    private lateinit var button3:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1=findViewById(R.id.button)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)

        val alertDialog=AlertDialog.Builder(this)
            .setTitle("Add Person")
            .setIcon(R.drawable.ic_add_to_group)
            .setMessage("Would you like to add this person to your group chat?")
            .setPositiveButton("Yes"){_,_->
                Toast.makeText(this,"Has been added to the group chat",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_->
                Toast.makeText(this,"Has not been added to the group chat",Toast.LENGTH_SHORT).show()
            }.create()

        button1.setOnClickListener(){
            alertDialog.show()
        }
    }
}