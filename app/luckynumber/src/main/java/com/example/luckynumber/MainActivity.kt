package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val LuckyNumber:EditText=findViewById(R.id.LuckyNumber)
        val LuckyButton:Button=findViewById(R.id.LuckyButton)

        val Button:Button=findViewById(R.id.button)
        val text:TextView=findViewById(R.id.textView3)


        val color:Int=ContextCompat.getColor(this,R.color.primary)

        val numberOfApples = 1
        val applesString = resources.getQuantityString(R.plurals.apples_quantity, numberOfApples, numberOfApples)


        Button.setOnClickListener(){
            text.text = applesString
            text.setBackgroundColor(color)
        }


        LuckyButton.setOnClickListener(){
            Intent(this, LuckyNumberActivity::class.java).also {
                it.putExtra("EXTRA_NAME",LuckyNumber.text.toString())
                startActivity(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.new_game -> {
                // Handle the click on the menu item
                // For example, you can show a toast message
                Toast.makeText(this, "Starting new game", Toast.LENGTH_SHORT).show()
                return true
            }
            // Add more cases for other menu items if needed
            else -> return super.onOptionsItemSelected(item)
        }
    }
}