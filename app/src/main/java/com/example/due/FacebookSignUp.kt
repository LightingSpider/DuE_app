package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class FacebookSignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook_sign_up)

        val button1 = findViewById<Button>(R.id.buttonn1)
        button1.setOnClickListener {
            val intent1 = Intent(this,SetProfile::class.java)
            startActivity(intent1)
        }
    }
}