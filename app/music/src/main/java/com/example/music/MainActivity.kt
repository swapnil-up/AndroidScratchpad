package com.example.music

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.sql.Time
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer:MediaPlayer
    private lateinit var handler: Handler
    private lateinit var timeLeft: TextView
    private lateinit var updateSongTime: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeLeft=findViewById(R.id.timeLeft)
        var songTitle:TextView=findViewById(R.id.songTitle)
        var seekBar:SeekBar=findViewById(R.id.seekBar)
        var pauseButton:Button=findViewById(R.id.pauseButton)
        var pressed:Boolean=false
        var finalTime:Double
        var currentTime:Double


        mediaPlayer=MediaPlayer.create(
            this,
            R.raw.everblue
        )

        seekBar.isClickable=false
        handler = Handler()

        updateSongTime=object :Runnable{
            override fun run() {
                currentTime=mediaPlayer.currentPosition.toDouble()
                timeLeft.text=""+ String.format(
                    "%d mmin, %d sec", TimeUnit.MILLISECONDS.toMinutes(currentTime.toLong()),
                    TimeUnit.MILLISECONDS.toSeconds(currentTime.toLong()-TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(currentTime.toLong())
                    ))
                )


                seekBar.progress=currentTime.toInt()
                handler.postDelayed(this,100)
            }
        }

        pauseButton.setOnClickListener(){
            if (!pressed) {
                mediaPlayer.start()
                finalTime=mediaPlayer.duration.toDouble()
                currentTime=mediaPlayer.currentPosition.toDouble()

                timeLeft.text=currentTime.toString()
                seekBar.max=finalTime.toInt()
                seekBar.progress=currentTime.toInt()


                pressed=true
                pauseButton.background=ContextCompat.getDrawable(this, R.drawable.play)
                handler.postDelayed(updateSongTime,100)
            }
            else{
                mediaPlayer.pause()
                pressed=false
                pauseButton.background=ContextCompat.getDrawable(this, R.drawable.pause)
            }
        }
    }
}