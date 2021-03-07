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