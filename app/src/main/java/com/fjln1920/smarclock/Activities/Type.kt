package com.fjln1920.smarclock.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.Helper

class Type : AppCompatActivity() {

    private lateinit var txtWord: TextView
    private lateinit var edtAnswer: EditText
    private lateinit var btnCheck: Button
    private  var randWord : String =  ""


    private lateinit var layoutCorrect: View
    private lateinit var layoutWrong: View

    private  val helper: Helper = Helper()


    private  val easyString =  listOf("HuWnmkY12H", "126HlkS", "klmsa", "KLÇasd67", "POTYRj0")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type)


        txtWord =  findViewById(R.id.txt_word)
        edtAnswer =  findViewById(R.id.edt_answer)
        btnCheck =  findViewById(R.id.btn_check_solution)


        layoutCorrect = findViewById(R.id.layout_correct)
        layoutWrong =  findViewById(R.id.layout_wrong)

        randWord =  helper.getRandString(easyString, 5)
        txtWord.text = randWord


        btnCheck.setOnClickListener {
          if (checkSolution(randWord, edtAnswer.text.toString()))
              layoutCorrect.visibility = View.VISIBLE
          else
              layoutWrong.visibility = View.VISIBLE
        }



    }



    fun checkSolution(text: String,  answerCompareTo: String) : Boolean{
        return text.equals(answerCompareTo)

    }



}
