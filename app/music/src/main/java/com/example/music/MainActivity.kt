package com.example.music

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var timeLeft:TextView=findViewById(R.id.timeLeft)
        var songTitle:TextView=findViewById(R.id.songTitle)
        var seekBar:SeekBar=findViewById(R.id.seekBar)
        var pauseButton:Button=findViewById(R.id.pauseButton)

        mediaPlayer=MediaPlayer.create(
            this,
            R.raw.everblue
        )

        seekBar.isClickable=false

        pauseButton.setOnClickListener(){
            mediaPlayer.start()
        }
    }
}