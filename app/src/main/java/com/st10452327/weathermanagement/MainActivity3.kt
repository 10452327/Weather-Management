package com.st10452327.weathermanagement

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.text.StringBuilder

    


class MainActivity3 : AppCompatActivity() {

    private lateinit var button_back: Button
    private lateinit var tv_information: TextView
    private lateinit var Minimum : TextView
    private lateinit var Maximum : TextView
    private lateinit var Weather_Condition : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        
        button_back = findViewById(R.id.Back)
        tv_information = findViewById(R.id.Information)
        Minimum = findViewById(R.id.Minimum)
        Maximum = findViewById(R.id.Maximum)
        Weather_Condition = findViewById(R.id.Condition)
        
        val dayArray = intent.getStringArrayExtra("dayArray")?.toList() ?: emptyList()
        val minimumArray = intent.getFloatArrayExtra("minimumArray")?.toList()?: emptyList()
        val maximumArray = intent.getFloatArrayExtra("maximumArray")?.toList()?: emptyList()
        val conditionArray = intent.getStringArrayExtra("conditionArray")?.toList()?: emptyList()
        
        val day = StringBuilder()
        for ((index, day) in dayArray.withIndex()){
            day.append("Day ${index + 1}:$day\n")
        }
        val Minimum = StringBuilder()
        for ((index, minimum) in minimumArray.withIndex()){
            Minimum.append("Minimum $index :$Minimum\n")
        }
        val Maximum = StringBuilder()
        for ((index, maximum) in maximumArray.withIndex()){
            Maximum.append("Maximum $index :$Maximum\n")
        }
        val condition = StringBuilder()
        for ((index, condition) in conditionArray.withIndex()){
            condition.append("Condition $condition: $condition\n")
        }
        tv_information.text = day.toString()
        Minimum.text = Minimum.toString()
        Maximum.text = Maximum.toString()
        Weather_Condition.text = condition.toString()
        
        button_back.setOnClickListener{
            finish()
        }
    }
}

private fun String.append(s: String) {
    TODO("Not yet implemented")
}
