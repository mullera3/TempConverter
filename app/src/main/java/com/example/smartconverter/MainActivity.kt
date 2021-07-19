package com.example.smartconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fField : TextView = findViewById(R.id.fahrenheit_input)  // variable controlling view for fahrenheit field
        var numberToBeConverted  : CharSequence // holds char sequence data coming from view
        val cField : TextView = findViewById(R.id.celsius_input) // variable controlling view  for Celsius field
        val convertButton : Button = findViewById(R.id.convert_button)  // variable controlling convert button view
        val resetButton : Button = findViewById(R.id.reset_button) // variable controlling reset button view

        // makes app listen for button click
        // basically when I click it will do what this block says
        // This listens for convert button click
        convertButton.setOnClickListener{
            // Checks to see if fields are empty from view
            if (fField.text.toString().isEmpty() && cField.text.toString().isEmpty())
            {
                // Prints quick message to screen if both fields are empty
                Toast.makeText(this, "You have to give a number to either input!", Toast.LENGTH_SHORT).show()
            }
            // Checks to see if one field is not empty
            else if (fField.text.toString().isEmpty() && cField.text.toString().isNotEmpty())
            {
                numberToBeConverted  = cField.text //grabs data from field
                var convertedNumber : Float = numberToBeConverted.toString().toFloat()
                // converts data to string then to float
                convertedNumber = ((convertedNumber * 1.8) + 32).toFloat(); // converts Celsius to fahrenheit
                fField.text = convertedNumber.toString() // sets view equal to new data

            }
            // Checks to see if one field is not empty
            else
            {
                numberToBeConverted  = fField.text //grabs data from field
                // converts data to string then to float
                var convertedNumber : Float = numberToBeConverted.toString().toFloat()
                convertedNumber = ((convertedNumber - 32) * 5/9);  // converts fahrenheit to Celsius
                cField.text = convertedNumber.toString() // sets view equal to new data

            }

        }

        // makes app listen for button click
        // basically when I click it will do what this block says
        // This listens for reset button click
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