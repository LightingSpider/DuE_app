package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.btn_LogIn)
        button1.setOnClickListener {
            val intent1 = Intent(this,MyProfile::class.java)
            startActivity(intent1)
        }

        val button2 = findViewById<Button>(R.id.btn_CreateAccount)
        button2.setOnClickListener {
            val intent2 = Intent(this,CreateAccount::class.java)
            startActivity(intent2)
        }

    }
}