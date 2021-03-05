package com.example.due

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.Button
import android.widget.ArrayAdapter
import android.widget.Spinner


class SetProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_profile)

        val button1 = findViewById<Button>(R.id.btnnext)
        button1.setOnClickListener {
            val intent1 = Intent(this,ChooseInterests::class.java)
            startActivity(intent1)
        }


        val geenders = arrayOf("Gender*","Male", "Female")
        val arrayAdapter = ArrayAdapter(this, R.layout.textspinner, geenders)
        val spg = findViewById<Spinner>(R.id.spinner_gender)
        spg.adapter = arrayAdapter
        spg.onItemSelectedListener = object :
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