package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val button1 = findViewById<Button>(R.id.btn_Register)
        button1.setOnClickListener {
            val intent1 = Intent(this,SetProfile::class.java)
            startActivity(intent1)
        }

        val button2 = findViewById<Button>(R.id.btnfb)
        button2.setOnClickListener {
            val intent2 = Intent(this,FacebookSignUp::class.java)
            startActivity(intent2)
        }

        val button3 = findViewById<Button>(R.id.btngoogle)
        button3.setOnClickListener {
            val intent3 = Intent(this,GoogleSignUp::class.java)
            startActivity(intent3)
        }
    }
}