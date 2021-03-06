package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class FacebookLogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook_log_in)

        val button1 = findViewById<Button>(R.id.buttonn)
        button1.setOnClickListener {
            val intent1 = Intent(this,Welcome::class.java)
            startActivity(intent1)
        }
    }
}