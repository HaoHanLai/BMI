package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMIActivity : AppCompatActivity() {
    var bmiIndex: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        val tvName = findViewById<TextView>(R.id.tvName)
        val personName = intent?.getStringExtra("personName") //? - not equal to null
        tvName.setText(personName)

        if (savedInstanceState != null){
            bmiIndex = savedInstanceState.getDouble("bmi") //get the value and restore back to bmiIndex

            val tvStatus = findViewById<TextView>(R.id.tvStatus)
            tvStatus.setText(getStatus())
        }

        val btnCal: Button = findViewById(R.id.btnCalculate)
        btnCal.setOnClickListener(){

            val weight = findViewById<TextView>(R.id.tfWeight).text.toString()
            val height = findViewById<TextView>(R.id.tfHeight).text.toString()

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            val tvStatus = findViewById<TextView>(R.id.tvStatus)

            tvStatus.setText(getStatus())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmi", bmiIndex) //store into bmi before being destroyed
    }

    fun getStatus():String{

        if(bmiIndex < 18.5)
            return "Underweight"
        else if(bmiIndex <= 24.9)
            return "Normal weight"
        else if(bmiIndex <= 29.9)
            return "Overweight"
        else if(bmiIndex <= 34.9)
            return "Obesity Class I"
        else
            return "Obesity Class II"

    }
}