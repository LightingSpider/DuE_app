package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class EditProfileNew : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile_new)

        val geenderss = arrayOf("Male", "Female")
        val arrayAdapter = ArrayAdapter(this, R.layout.textspinner, geenderss)
        val spgg = findViewById<Spinner>(R.id.spinner_genderr)
        spgg.adapter = arrayAdapter
        spgg.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                //To change body of created
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //To change body of created
            }

        }

        val interr = arrayOf("Women", "Men", "Both")
        val arrayAdapter2 = ArrayAdapter(this, R.layout.textspinner, interr)
        val spg22 = findViewById<Spinner>(R.id.spinner_interestedinnn)
        spg22.adapter = arrayAdapter2
        spg22.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                //To change body of created
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //To change body of created
            }

        }

        val button1 = findViewById<Button>(R.id.btnsave)
        button1.setOnClickListener {
            val intent1 = Intent(this,MyProfile::class.java)
            startActivity(intent1)
        }
    }
}