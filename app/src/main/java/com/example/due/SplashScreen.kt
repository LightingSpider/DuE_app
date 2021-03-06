package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val logodue1 = findViewById<ImageView>(R.id.logodue)
        logodue1.alpha = 0f
        logodue1.animate().setDuration(2000).alpha(2f).withEndAction {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}