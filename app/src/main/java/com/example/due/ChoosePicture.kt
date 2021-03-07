package com.example.due

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ChoosePicture : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_picture)

        val button2 = findViewById<Button>(R.id.btn_next)
        button2.setOnClickListener {
            val intent2 = Intent(this,AccountReady::class.java)
            startActivity(intent2)
        }

        val button1 = findViewById<Button>(R.id.btn_choosepicture)
        button1.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_DENIED) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE)
                }
                else {
                    //permission already granted
                    pickImageFromGallery();
                }
            }
            else {
                //system OS is < Marshmallo
                pickImageFromGallery();
            }
        }
    }

    private fun pickImageFromGallery() {
        val intent1 = Intent(Intent.ACTION_PICK)
        intent1.type = "image/*"
        startActivityForResult(intent1, IMAGE_PICK_CODE)
    }

    companion object {
        const val IMAGE_PICK_CODE = 1000;
        private const val PERMISSION_CODE = 1001;

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else {
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            val imagevieww1 = findViewById<ImageView>(R.id.imagevieww)
            imagevieww1.setImageURI(data?.data)
        }
    }

}