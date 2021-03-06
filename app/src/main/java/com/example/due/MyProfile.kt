package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        val image = findViewById<ImageView>(R.id.imageView10)
        image.setOnClickListener {
            val intent1 = Intent(this,Welcome::class.java)
            startActivity(intent1)
        }

        val edit = findViewById<Button>(R.id.buttonedit)
        edit.setOnClickListener {
            val intent2 = Intent(this,Welcome::class.java)
            startActivity(intent2)
        }

        val interestss1 = findViewById<View>(R.id.view5)
        interestss1.setOnClickListener {
            val intent3 = Intent(this,Welcome::class.java)
            startActivity(intent3)
        }

        val interestss2 = findViewById<TextView>(R.id.textView27)
        interestss2.setOnClickListener {
            val intent4 = Intent(this,Welcome::class.java)
            startActivity(intent4)
        }

        val interestss3 = findViewById<TextView>(R.id.textView28)
        interestss3.setOnClickListener {
            val intent5 = Intent(this,Welcome::class.java)
            startActivity(intent5)
        }

    }
}