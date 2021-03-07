package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class Messages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        val button1 = findViewById<Button>(R.id.location_buttond)
        button1.setOnClickListener {
            val intent1 = Intent(this,HomePageNew::class.java)
            startActivity(intent1)
        }

        val button2 = findViewById<Button>(R.id.profile_buttond)
        button2.setOnClickListener {
            val intent2 = Intent(this,MyProfile::class.java)
            startActivity(intent2)
        }

        val interestss1 = findViewById<View>(R.id.view5)
        interestss1.setOnClickListener {
            val intent3 = Intent(this,EditInterests::class.java)
            startActivity(intent3)
        }

        val interestss2 = findViewById<TextView>(R.id.textView27)
        interestss2.setOnClickListener {
            val intent4 = Intent(this,EditInterests::class.java)
            startActivity(intent4)
        }

        val interestss3 = findViewById<TextView>(R.id.textView28)
        interestss3.setOnClickListener {
            val intent5 = Intent(this,EditInterests::class.java)
            startActivity(intent5)
        }
    }
}