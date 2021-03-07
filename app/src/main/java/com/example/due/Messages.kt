package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class Messages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        val seenUsers = intent!!.getParcelableArrayListExtra<UserInfo>("seenUsers") as ArrayList<UserInfo>


        val button1 = findViewById<Button>(R.id.location_buttond)
        button1.setOnClickListener {
            val intent1 = Intent(this,HomePageNew::class.java)
            startActivity(intent1)
        }

        val button2 = findViewById<Button>(R.id.profile_buttond)
        button2.setOnClickListener {
            val intent2 = Intent(this,MyProfile::class.java)
            intent.putExtra("seenUsers", seenUsers)
            startActivity(intent2)
        }
    }
}