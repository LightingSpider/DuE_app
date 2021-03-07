package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
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

        val intentt = Intent(this,ChatRoom::class.java)

        val int1= findViewById<ImageView>(R.id.imageView8)
        int1.setOnClickListener {
            startActivity(intentt)
        }

        val int2 = findViewById<View>(R.id.viewchat2)
        int2.setOnClickListener {
            startActivity(intentt)
        }

        val int3 = findViewById<TextView>(R.id.name2)
        int3.setOnClickListener {
            startActivity(intentt)
        }

        val int4 = findViewById<TextView>(R.id.message2)
        int4.setOnClickListener {
            startActivity(intentt)
        }

        val int5 = findViewById<TextView>(R.id.place2)
        int5.setOnClickListener {
            startActivity(intentt)
        }

    }
}