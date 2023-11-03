package com.example.luckynumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val LuckyNumberResult:TextView=findViewById(R.id.LuckyNumberResult)
        val shareButton:Button=findViewById(R.id.shareButton)
        val username=receiveUsername()
        Toast.makeText(this, username,Toast.LENGTH_LONG).show()
    }

    fun receiveUsername(): String {
        var bundle: Bundle? = intent.extras
        return bundle?.getString("EXTRA_NAME").toString()
    }

}