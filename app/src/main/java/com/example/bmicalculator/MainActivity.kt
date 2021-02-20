package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter: Button = findViewById(R.id.btnEnter)

        btnEnter.setOnClickListener(){

            val tfName = findViewById<TextView>(R.id.tfName)

            val intent = Intent(this, BMIActivity::class.java)

            intent.putExtra("personName", tfName.text.toString()) //pass string to another activity

            startActivity(intent);
        }


    }
}