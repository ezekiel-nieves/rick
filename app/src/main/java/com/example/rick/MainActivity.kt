package com.example.rick


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var isPlaying = false
        var videoName = "RICK"
        var isChanged = false
        val videoplayer = findViewById<VideoView>(R.id.videoViewer)
        val ppButton = findViewById<ImageButton>(R.id.ppbutton)
        val videoText = findViewById<TextView>(R.id.videotext)
        videoplayer.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.ourboyrick))
        videoplayer.requestFocus()

        videoplayer.setOnPreparedListener {
            println("bruh")
        }

        videoplayer.setOnClickListener {
             isChanged = true
            if (videoName == "PERSONA") {
                videoText.text = "play this game"
            }
            if (videoName == "BEAST") {
                videoText.text = "furry"

            }
            if (videoName == "RICK") {
                videoText.text = "this dude is a simp"

            }
        }

        fun changeText() {
            videoText.isInvisible = false
            if (videoName == "RICK") {
                videoText.text = getString(R.string.rick)
                return
            }
            if (videoName == "PERSONA") {
                videoText.text = getString(R.string.persona)
            }
            if (videoName == "BEAST") {
                videoText.text = getString(R.string.beast)
            }
        }
        ppButton.setOnClickListener {
            nextbutton.isInvisible = false
            backbutton.isInvisible = false
            if (isPlaying == true) {
                videoplayer.pause()
                isPlaying = false
                ppButton.setImageResource(R.drawable.baseline_play_circle_outline_white_18dp)
                println()
                return@setOnClickListener
            }
            if (isPlaying == false) {
                videoplayer.start()
                isPlaying = true
                if (isChanged == false) {
                    changeText()
                }
                ppButton.setImageResource(R.drawable.baseline_pause_circle_outline_white_18dp)
                return@setOnClickListener
            }
        }
        nextbutton.setOnClickListener {
            ppButton.setImageResource(R.drawable.baseline_pause_circle_outline_white_18dp)
            isPlaying = true

            if (videoName == "RICK") {
                videoplayer.suspend()
                videoplayer.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.persona))
                videoName = "PERSONA"
                videoplayer.resume()
                videoplayer.start()
                println("it work")
                changeText()
                return@setOnClickListener
            }
            if (videoName == "PERSONA") {
                videoplayer.suspend()
                videoplayer.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.beast))
                videoName = "BEAST"
                videoplayer.resume()
                videoplayer.start()
                println("it work")
                changeText()
                return@setOnClickListener
            }
            if (videoName == "BEAST") {
                videoplayer.suspend()
                videoplayer.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.ourboyrick))
                videoName = "RICK"
                videoplayer.resume()
                videoplayer.start()
                println("it work")
                changeText()
                return@setOnClickListener
            }

        }
        backbutton.setOnClickListener {
            ppButton.setImageResource(R.drawable.baseline_pause_circle_outline_white_18dp)
            isPlaying = true
            if (videoName == "RICK") {
                videoplayer.suspend()
                videoplayer.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.beast))
                videoName = "BEAST"
                videoplayer.resume()
                videoplayer.start()
                println("it work")
                changeText()
                return@setOnClickListener
            }
            if (videoName == "PERSONA") {
                videoplayer.suspend()
                videoplayer.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.ourboyrick))
                videoName = "RICK"
                videoplayer.resume()
                videoplayer.start()
                println("it work")
                changeText()
                return@setOnClickListener
            }
            if (videoName == "BEAST") {
                videoplayer.suspend()
                videoplayer.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.persona))
                videoName = "PERSONA"
                videoplayer.resume()
                videoplayer.start()
                println("itplay")
                changeText()
                return@setOnClickListener
            }
        }
    }

    override fun onStop() {
        super.onStop()
        videoViewer.start()
    }

}