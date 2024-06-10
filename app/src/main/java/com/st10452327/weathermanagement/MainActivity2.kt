package com.st10452327.weathermanagement

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity2 : AppCompatActivity() {
    private lateinit var editTextDay: EditText
    private lateinit var editTextMin: EditText
    private lateinit var editTextMax: EditText
    private lateinit var editTextCondition: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonClear: Button
    private lateinit var buttonNext: Button
    private lateinit var Message: TextView
    //add
    private val dayArray = mutableListOf<String>()
    private val minimumArray = mutableListOf<Float>()
    private val maximumArray = mutableListOf<Float>()
    private val conditionArray = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        editTextDay = findViewById(R.id.editTextDay)
        editTextMin = findViewById(R.id.editTextMin)
        editTextMax = findViewById(R.id.editTextMax)
        editTextCondition = findViewById(R.id.editTextCondition)
        buttonSave = findViewById(R.id.Save)
        buttonClear = findViewById(R.id.Clear)
        buttonNext = findViewById(R.id.Next)
        Message = findViewById(R.id.Message)

        buttonClear.setOnClickListener{
            editTextDay.setText("")
            editTextMin.setText("")
            editTextMax.setText("")
            editTextCondition.setText("")
        }

        buttonSave.setOnClickListener{
            val screenTimeDay = editTextDay.text.toString()
            val screenTimeMinimum = editTextMin.text.toString()
            val screenTimeMaximum =editTextMax.text.toString()
            val screenTimeCondition = editTextCondition.text.toString()

            if (screenTimeDay.isEmpty()&& screenTimeMinimum.isNotEmpty()&& screenTimeMaximum.isNotEmpty()) {
                try {
                    dayArray
                    minimumArray.add(screenTimeMinimum.toFloat())
                    maximumArray.add(screenTimeMaximum.toFloat())
                    conditionArray.add((screenTimeCondition))
                    editTextDay.text.clear()
                    editTextMin.text.clear()
                    editTextMax.text.clear()
                    editTextCondition.text.clear()
                } catch (e: NumberFormatException) {
                    Message.text = "Please enter a valid number"
                }
                }else{
                    Message.text = "Input cannot be empty"
            }

        }

        buttonNext.setOnClickListener{
            val intent = Intent(this,MainActivity3::class.java)
            intent.putExtra("dayArray",dayArray.toTypedArray())
            intent.putExtra("minimumArray",minimumArray.toFloatArray())
            intent.putExtra("maximumArray",maximumArray.toFloatArray())
            intent.putExtra("conditionArray",conditionArray.toTypedArray())
            startActivity(intent)
        }

    }
}