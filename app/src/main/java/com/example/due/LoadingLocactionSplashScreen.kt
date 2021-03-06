package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class LoadingLocactionSplashScreen : AppCompatActivity() {

    private val SPLASH_TIME: Long = 3500

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_locaction_splash_screen)

        Handler().postDelayed({
            startActivity(Intent (this, HomePageNew::class.java))
            finish()
        }, SPLASH_TIME)

    }
}