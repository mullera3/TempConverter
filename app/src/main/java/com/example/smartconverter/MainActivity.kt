package com.example.smartconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fField : TextView = findViewById(R.id.fahrenheit_input)
        var numberToBeConverted  : CharSequence
        val cField : TextView = findViewById(R.id.celsius_input)
        val convertButton : Button = findViewById(R.id.convert_button)
        val resetButton : Button = findViewById(R.id.reset_button)
        convertButton.setOnClickListener{
            if (fField.text.toString().isEmpty() && cField.text.toString().isEmpty())
            {
                Toast.makeText(this, "You have to give a number to either input!", Toast.LENGTH_SHORT).show()
            }
            else if (fField.text.toString().isEmpty() && cField.text.toString().isNotEmpty())
            {
                numberToBeConverted  = cField.text
                var convertedNumber : Float = numberToBeConverted.toString().toFloat()
                convertedNumber = ((convertedNumber * 1.8) + 32).toFloat();
                fField.text = convertedNumber.toString()

            }
            else
            {
                numberToBeConverted  = fField.text
                var convertedNumber : Float = numberToBeConverted.toString().toFloat()
                convertedNumber = ((convertedNumber - 32) * 5/9);
                cField.text = convertedNumber.toString()

            }

        }

        resetButton.setOnClickListener {
            if (fField.text.toString().isEmpty() && cField.text.toString().isEmpty())
            {
                val toast = Toast.makeText(this,"Input field is already empty!", Toast.LENGTH_SHORT)
                toast.show()

            }
            else {
                fField.text = ""
                cField.text = ""
            }
        }
    }
}