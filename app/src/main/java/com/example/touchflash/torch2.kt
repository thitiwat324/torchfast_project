package com.example.touchflash

import android.content.Intent
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class torch2 : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torch2)
        var backView=findViewById<Button>(R.id.button3)
        backView.setOnClickListener {
            var intent5=Intent(this,MainActivity::class.java)
            startActivity(intent5)
        }
        var Getout=findViewById<Button>(R.id.button4)
        Getout.setOnClickListener {
            finishAffinity()
        }
        var mp:MediaPlayer
        mp=MediaPlayer()
        mp=MediaPlayer.create(this,R.raw.menubutton)


        val onButton = findViewById<Button>(R.id.flash_on)

        val offButton = findViewById<Button>(R.id.flash_off)

        onButton.setOnClickListener {
            mp.start()
            onFlash()
        }
        offButton.setOnClickListener {
            mp.start()
            offFlash()
        }
    }

    private fun onFlash() {
        var cameraManager: CameraManager? = null
        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager

        try {
            var cameraId: String? = null
            cameraId = cameraManager.cameraIdList[0]
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager!!.setTorchMode(cameraId, true)

            }
            Toast.makeText(this, "FLash ON", Toast.LENGTH_SHORT).show()

        } catch (e: CameraAccessException) {
            //Toast.makeText(this,"Exception:"+e.message).show()
        }
    }

    private fun offFlash() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val cameraManage = getSystemService(CAMERA_SERVICE) as CameraManager

            try {
                val cameraId = cameraManage.cameraIdList[0]
                cameraManage.setTorchMode(cameraId, false)
                Toast.makeText(this, "FLash OFF", Toast.LENGTH_SHORT).show()
            } catch (e: CameraAccessException) {

            }
        }
    }
}
