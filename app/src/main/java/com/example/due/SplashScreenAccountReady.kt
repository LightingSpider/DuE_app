package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashScreenAccountReady : AppCompatActivity() {
    private val SPLASH_TIME: Long = 2500
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_account_ready)

        Handler().postDelayed({
            startActivity(Intent (this, Welcome::class.java))
            finish()
        }, SPLASH_TIME)
    }

}