package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.CheckBox

class ChooseInterests : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_interests)

        val button1 = findViewById<Button>(R.id.btn_internext)
        button1.setOnClickListener {
            val intent1 = Intent(this,ChoosePicture::class.java)
            startActivity(intent1)
        }
    }
    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_animals -> {
                    if (checked) {
                        // Put some meat on the sandwich
                    } else {
                        // Remove the meat
                    }
                }
                R.id.checkbox_books -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                R.id.checkbox_cook -> {
                    if (checked) {
                        // Put some meat on the sandwich
                    } else {
                        // Remove the meat
                    }
                }
                R.id.checkbox_dance -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                R.id.checkbox_envir -> {
                    if (checked) {
                        // Put some meat on the sandwich
                    } else {
                        // Remove the meat
                    }
                }
                R.id.checkbox_fashion -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                R.id.checkbox_movies -> {
                    if (checked) {
                        // Put some meat on the sandwich
                    } else {
                        // Remove the meat
                    }
                }
                R.id.checkbox_photos -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                R.id.checkbox_politics -> {
                    if (checked) {
                        // Put some meat on the sandwich
                    } else {
                        // Remove the meat
                    }
                }
                R.id.checkbox_spirit -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                R.id.checkbox_travel -> {
                    if (checked) {
                        // Put some meat on the sandwich
                    } else {
                        // Remove the meat
                    }
                }
                R.id.checkbox_sports -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                R.id.checkbox_volut -> {
                    if (checked) {
                        // Put some meat on the sandwich
                    } else {
                        // Remove the meat
                    }
                }

                // TODO: Veggie sandwich
            }
        }
    }
}