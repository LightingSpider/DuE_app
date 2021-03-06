package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val wel = findViewById<TextView>(R.id.welcome)
        wel.alpha = 0f
        wel.animate().setDuration(2000).alpha(2f).withEndAction {
            val i = Intent(this,AskPermissionLoco::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}