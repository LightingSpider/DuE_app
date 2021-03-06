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

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val button1 = findViewById<Button>(R.id.btnsave)
        button1.setOnClickListener {
            val intent1 = Intent(this,MyProfile::class.java)
            startActivity(intent1)
        }
        val button2 = findViewById<Button>(R.id.messages_buttondp)
        button2.setOnClickListener {
            val intent2 = Intent(this,Messages::class.java)
            startActivity(intent2)
        }
        val button3 = findViewById<Button>(R.id.location_buttondp)
        button3.setOnClickListener {
            val intent3 = Intent(this,HomePageNew::class.java)
            startActivity(intent3)
        }

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
        val spg2 = findViewById<Spinner>(R.id.spinner_interestedinnn)
        spg2.adapter = arrayAdapter2
        spg2.onItemSelectedListener = object :
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
    }
}