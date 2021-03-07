package com.example.due

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MyProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        val button1 = findViewById<Button>(R.id.location_buttondp)
        button1.setOnClickListener {
            val intent1 = Intent(this,HomePageNew::class.java)
            startActivity(intent1)
        }

        val button2 = findViewById<Button>(R.id.messages_buttondp)
        button2.setOnClickListener {
            val intent2 = Intent(this,Messages::class.java)
            startActivity(intent2)
        }

        val image = findViewById<ImageView>(R.id.imageView10)
        image.setOnClickListener {
            pickImageFromGallery()
        }

        val edit = findViewById<Button>(R.id.buttonedit)
        edit.setOnClickListener {
            val intent2 = Intent(this,EditProfile::class.java)
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

    private fun pickImageFromGallery() {
        val intent1 = Intent(Intent.ACTION_PICK)
        intent1.type = "image/*"
        startActivityForResult(intent1, iIMAGE_PICK_CODE)
    }

    companion object {
        const val iIMAGE_PICK_CODE = 1000;
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == iIMAGE_PICK_CODE) {
            val imagevieww1 = findViewById<ImageView>(R.id.imageView10)
            imagevieww1.setImageURI(data?.data)
        }
    }
}