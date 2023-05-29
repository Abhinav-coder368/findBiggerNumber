package com.example.findbiggernumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnleft.setOnClickListener {

            answerCheck(true)
            assignNumbersToButtons()
        }
        btnright.setOnClickListener {
            answerCheck(false)
            assignNumbersToButtons()
        }

    }

    private fun assignNumbersToButtons() {
        val r  = Random()
        val leftNum = r.nextInt(10)
        var rightNum = leftNum
        while (leftNum == rightNum) {
            rightNum = r.nextInt(10)
        }
        btnleft.text = leftNum.toString()
        btnright.text = rightNum.toString()
    }

    private fun answerCheck(isLeftButtonSelected : Boolean){
        val leftNum = btnleft.text.toString().toInt()
        val rightNum = btnright.text.toString().toInt()
        val isAnswerCorrect = if(isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if(isAnswerCorrect){

                conslayout.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            }
            else{
                conslayout.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }
        }
}



