package com.example.music

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var timeLeft:TextView=findViewById(R.id.timeLeft)
        var songTitle:TextView=findViewById(R.id.songTitle)
        var seekBar:SeekBar=findViewById(R.id.seekBar)
        var pauseButton:Button=findViewById(R.id.pauseButton)
        var pressed:Boolean=false


        mediaPlayer=MediaPlayer.create(
            this,
            R.raw.everblue
        )

        seekBar.isClickable=false

        pauseButton.setOnClickListener(){
            if (!pressed) {
                mediaPlayer.start()
                pressed=true
                pauseButton.background=ContextCompat.getDrawable(this, R.drawable.play)
            }
            else{
                mediaPlayer.pause()
                pressed=false
                pauseButton.background=ContextCompat.getDrawable(this, R.drawable.pause)
            }
        }
    }
}