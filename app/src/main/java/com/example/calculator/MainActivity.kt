package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView : TextView
    private lateinit var equalsbutton : Button
    private var operand : Double = 0.0
    private var operation : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.init()
        equalsbutton.setOnClickListener{
            val secoperandText : String = resultTextView.text.toString()
            var secoperand : Double = 0.0
            if(secoperandText.isNotEmpty()){
                secoperand = secoperandText.toDouble()
            }
            when(this.operation){
                "+"-> resultTextView.text = (operand + secoperand).toString()
                "-"-> resultTextView.text = (operand - secoperand).toString()
                "*"-> resultTextView.text = (operand * secoperand).toString()
                "/"-> resultTextView.text = (operand / secoperand).toString()
                "%"-> resultTextView.text = (operand /100 * secoperand).toString()
                "√"-> resultTextView.text = (Math.sqrt(operand).toString())
            }
        }
    }

    private fun init(){
        resultTextView = findViewById(R.id.resultTextView)
        equalsbutton = findViewById(R.id.equalsbutton)
    }

    fun numberClick(view : View){
        if(view is Button){
            val number = view.text.toString()
            var result = resultTextView.text.toString()
            if(result == "0"){
                result = ""
            }
            resultTextView.text = result + number
        }
    }

    fun operationClick(view : View){
        if(view is Button){
            if(resultTextView.text.toString().isNotEmpty()){
                operand = resultTextView.text.toString().toDouble()
            }
            operation = view.text.toString()
            resultTextView.text = ""
        }
    }

    fun cleanClick(view : View){
        if(view is Button){
            if(resultTextView.text.toString().isNotEmpty()){
                resultTextView.text = ""
            }
        }
    }

    fun dotClick(view : View){
        if(view is Button){
            resultTextView.text.toString().toDouble()
        }
    }
}