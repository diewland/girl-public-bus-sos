package com.diewland.girlpublicbussos

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var media1:MediaPlayer? = null
    private var media2:MediaPlayer? = null

    private var mAudioManager:AudioManager? = null
    private var deviceVol = 0
    private var maxVol = 15

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize medias
        media1 = MediaPlayer.create(this, R.raw.aggressive1)
        media2 = MediaPlayer.create(this, R.raw.aggressive2)

        val btnSos = findViewById<Button>(R.id.btn_sos)

        // on click
        btnSos.setOnClickListener {
            media1?.seekTo(1000)
            media1?.start()
        }

        // on long click
        btnSos.setOnLongClickListener{
            media2?.seekTo(500)
            media2?.start()
            true
        }

    }

    override fun onResume() {
        super.onResume()

        // get audio manager
        if(mAudioManager == null){
            mAudioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        }

        // update device/max volume
        deviceVol = mAudioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)
        maxVol = mAudioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

        // set volume to max
        mAudioManager!!.setStreamVolume( AudioManager.STREAM_MUSIC, maxVol, 0 )
    }

    override fun onPause() {
        // restore device volume
        mAudioManager!!.setStreamVolume( AudioManager.STREAM_MUSIC, deviceVol, 0 )

        super.onPause()
    }
}
