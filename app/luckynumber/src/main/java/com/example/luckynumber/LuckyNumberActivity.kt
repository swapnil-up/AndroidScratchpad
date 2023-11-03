package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val LuckyNumberResult:TextView=findViewById(R.id.LuckyNumberResult)
        val shareButton:Button=findViewById(R.id.shareButton)

        val username=receiveUsername()
        val number=randomNumberGenerator()
        LuckyNumberResult.text = "$number"
        shareButton.setOnClickListener {
            shareData(username, number)
        }
    }

    fun receiveUsername(): String {
        var bundle: Bundle? = intent.extras
        return bundle?.getString("EXTRA_NAME").toString()
    }

    fun randomNumberGenerator():Int{
        return Random.nextInt(1000)
    }

    fun shareData(username:String, number:Int){
        Intent(Intent.ACTION_SEND).also {
            it.type = "text/plain"
            it.putExtra(Intent.EXTRA_SUBJECT,"$username is sharing luck")
            it.putExtra(Intent.EXTRA_TEXT,"Luck shared is $number")
            startActivity(it)
        }
    }

}