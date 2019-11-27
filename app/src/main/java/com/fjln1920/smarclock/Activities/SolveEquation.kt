package com.fjln1920.smarclock.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.Helper

class SolveEquation : AppCompatActivity() {

    private lateinit var txtQuestion : TextView
    private  lateinit var edtAnswer: EditText
    private  lateinit var btnCheck:  Button
    private  val helper: Helper =  Helper()




    private  val easyEquation =  listOf("2+2 = x ","5+3 = 3 + X ", "15 * 5 ", "x + 3 = 4 * 5 ")


    private var equations : HashMap<String, String> = HashMap()

    private lateinit var equatoinHashMapKey: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solve_equation)

        equations["2+2 = x "] = "4"
        equations["5+3 = 3 + X "] = "5"
        equations["15 * 5 "] = "75"
        equations["x + 3 = 4 * 5 "] = "17"


        equatoinHashMapKey = helper.getRandEquationKey(easyEquation, 4)

        txtQuestion =  findViewById(R.id.txt_question)
        edtAnswer =  findViewById(R.id.edt_answer)
        btnCheck =  findViewById(R.id.btn_check_solution)

        txtQuestion.text =  equatoinHashMapKey




        btnCheck.setOnClickListener {

             if (checkSolution(equatoinHashMapKey, edtAnswer.text.toString())){
              Toast.makeText(this, "acertou", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "errou", Toast.LENGTH_LONG).show()
            }

            Log.e("ok", "ok")

        }


    }


    fun checkSolution(quention: String,  answerCompareTo: String) : Boolean{
        return equations[quention]!!.equals(answerCompareTo)

    }



}
