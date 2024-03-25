package com.example.touchflash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var newView=findViewById<Button>(R.id.button)
        newView.setOnClickListener {
            var intent4=Intent(this,torch2::class.java)
            startActivity(intent4)
        }
        var Getout=findViewById<Button>(R.id.button2)
        Getout.setOnClickListener {
            finishAffinity()
        }
    }
}