package com.example.awspolly.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.example.awspolly.R

class AudioPlayerService : Service() {

    private lateinit var mAudioPlayer: MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val message = intent?.extras?.getBoolean("message")

        if (message!!) {
            mAudioPlayer = MediaPlayer.create(this, R.raw.test)
            mAudioPlayer.start()
        } else {
            mAudioPlayer.stop()
            mAudioPlayer.release()
        }

        return START_NOT_STICKY
    }

}
