package com.fjln1920.smarclock.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.fjln1920.smarclock.R

class MemoryGame : AppCompatActivity() {

    private val easy0: ByteArray =  byteArrayOf(0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,1)
    private val easy1: ByteArray =  byteArrayOf(0,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0)
    private val easy2: ByteArray =  byteArrayOf(1,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0)
    private val easy3: ByteArray =  byteArrayOf(1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0)

    private lateinit var arrayToUse: ByteArray



   // private val table: ByteArray = byteArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

    // btn variables
    private lateinit var btn1: Button
    private lateinit var btn2: Button

    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn10: Button
    private lateinit var btn11: Button
    private lateinit var btn12: Button
    private lateinit var btn13: Button
    private lateinit var btn14: Button
    private lateinit var btn15: Button
    private lateinit var btn16: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_game)

        arrayToUse = getRandonEasyArray()


        btn1 = findViewById(R.id.memory_game_btn1)
        btn2 = findViewById(R.id.memory_game_btn2)
        btn3 = findViewById(R.id.memory_game_btn3)
        btn4 = findViewById(R.id.memory_game_btn4)
        btn5 = findViewById(R.id.memory_game_btn5)
        btn6 = findViewById(R.id.memory_game_btn6)
        btn7 = findViewById(R.id.memory_game_btn7)

        btn8 = findViewById(R.id.memory_game_btn8)
        btn9 = findViewById(R.id.memory_game_btn9)
        btn10 = findViewById(R.id.memory_game_btn10)
        btn11 = findViewById(R.id.memory_game_btn11)
        btn12 = findViewById(R.id.memory_game_btn12)
        btn13 = findViewById(R.id.memory_game_btn13)
        btn14 = findViewById(R.id.memory_game_btn14)

        btn15 = findViewById(R.id.memory_game_btn15)
        btn16 = findViewById(R.id.memory_game_btn16)

        setContentView(R.layout.layout_memorize)
        //putOnGreenToShow(arrayToUse)
        setClick()
















    }


    fun  getRandonEasyArray(): ByteArray {
        val randInt = (0..3).random()
        return when (randInt) {
            0 -> easy0
            1 -> easy1
            2 -> easy2
            else -> easy3
        }

    }


    fun validateMemory(btnPosstion: Int, btn: Button){

        if (arrayToUse[btnPosstion].toInt()==0){
            btn.setBackgroundResource(R.drawable.memory_game_btn_bg_red)
        }else{
            btn.setBackgroundResource(R.drawable.memory_game_btn_bg_green)
        }

    }
/*
    // criaçao da tabela memory q mosta as posiçoes(for em kotlin)
    fun putOnGreenToShow(btnPosition: Int, arrayToUse: ByteArray, btn: Button){
        for (btnPosition in 0 until 15)
        if (arrayToUse[btnPosition].toInt()==1){
            btn.setBackgroundResource(R.drawable.memory_game_btn_bg_green)
        }

    }

    fun setBtn(btnPosition: Int){
        if (btnPosition = 0){
            return btn1
        } else if(btnPosition = 1){
            return btn2
        }else if (btnPosition = 2){
            return btn3
        }else if (btnPosition = 3){
            return btn4
        }else if (btnPosition = 4){
            return btn5
        }else if (btnPosition = 5){
            return btn6
        }else if (btnPosition = 6){
            return btn7
        }else if (btnPosition = 7){
            return btn8
        }else if (btnPosition = 8){
            return btn9
        }else if (btnPosition = 9){
            return btn10
        }else if (btnPosition = 10){
            return btn11
        }else if (btnPosition = 11){
            return btn12
        }else if (btnPosition = 12){
            return btn13
        }else if (btnPosition = 13){
            return btn14
        }else if (btnPosition = 14){
            return btn15
        }else {
            return btn16
        }
    }
*/

    fun setClick(){
        btn1.setOnClickListener {
            validateMemory(0, btn1)
        }
        btn2.setOnClickListener {
            validateMemory(1, btn2)
        }
        btn3.setOnClickListener {
            validateMemory(2, btn3)
        }
        btn4.setOnClickListener {
            validateMemory(3, btn4)
        }
        btn5.setOnClickListener {
            validateMemory(4, btn5)
        }
        btn6.setOnClickListener {
            validateMemory(5, btn6)
        }
        btn7.setOnClickListener {
            validateMemory(6, btn7)
        }
        btn8.setOnClickListener {
            validateMemory(7, btn8)
        }
        btn9.setOnClickListener {
            validateMemory(8, btn9)
        }
        btn10.setOnClickListener {
            validateMemory(9, btn10)
        }
        btn11.setOnClickListener {
            validateMemory(10, btn11)
        }
        btn12.setOnClickListener {
            validateMemory(11, btn12)
        }
        btn13.setOnClickListener {
            validateMemory(12, btn13)
        }
        btn14.setOnClickListener {
            validateMemory(13, btn14)
        }
        btn15.setOnClickListener {
            validateMemory(14, btn15)
        }
        btn16.setOnClickListener {
            validateMemory(15, btn16)
        }

    }





}
