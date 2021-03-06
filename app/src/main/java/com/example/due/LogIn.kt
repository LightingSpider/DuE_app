package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val button1 = findViewById<Button>(R.id.btnnlog)
        button1.setOnClickListener {
            val intent1 = Intent(this,Welcome::class.java)
            startActivity(intent1)
        }

        val button2 = findViewById<Button>(R.id.btnloginfb)
        button2.setOnClickListener {
            val intent2 = Intent(this,FacebookLogIn::class.java)
            startActivity(intent2)
        }

        val button3 = findViewById<Button>(R.id.btnlogingoogle)
        button3.setOnClickListener {
            val intent3 = Intent(this,GoogleLogIn::class.java)
            startActivity(intent3)
        }
    }
}