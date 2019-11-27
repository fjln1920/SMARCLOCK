package com.fjln1920.smarclock.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.Constants
import com.fjln1920.smarclock.service.AlarmService
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class MemoryGame : AppCompatActivity() {

    private var level = 0

    private val easy0: ByteArray = byteArrayOf(0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1)
    private val easy1: ByteArray = byteArrayOf(0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0)
    private val easy2: ByteArray = byteArrayOf(1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0)
    private val easy3: ByteArray = byteArrayOf(1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0)

    private val hard0: ByteArray = byteArrayOf(1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1)
    private val hard1: ByteArray = byteArrayOf(1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1)
    private val hard2: ByteArray = byteArrayOf(1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1)


    //teste testeUnitario


    private lateinit var arrayToUse: ByteArray
    private lateinit var layoutCorrect: View;
    private lateinit var layoutWrong: View

    private var count = 0



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
        createViewByLayout()


        level = intent.getIntExtra("level", 0)

        layoutCorrect = findViewById(R.id.layout_correct)
        layoutWrong = findViewById(R.id.layout_wrong)


        startGameByLevel(level)



    }

    private fun getRandonHardArray(): ByteArray {
        return when ((0..2).random()) {
            0 -> hard0
            1 -> hard1
            else -> hard2
        }

    }

    private fun getRandonEasyArray(): ByteArray {
        return when ((0..3).random()) {
            0 -> easy0
            1 -> easy1
            2 -> easy2
            else -> easy3
        }

    }


    private fun validateMemory(btnPosition: Int) {
        if (arrayToUse[btnPosition].toInt() == 0) {

            layoutWrong.visibility = View.VISIBLE
            changeTableColor(R.drawable.memory_game_btn_bg_white)
            count = 0
            Handler().postDelayed({

                layoutWrong.visibility = View.GONE
                startGameByLevel(level)
            }, 1000)


        } else {
            getBtnByPosition(btnPosition).setBackgroundResource(R.drawable.memory_game_btn_bg_green)
            count++
            if (checkDone(level)) {
                layoutCorrect.visibility = View.VISIBLE
                val intentToService = Intent(this, AlarmService::class.java)
                intentToService.putExtra("ON_OFF", Constants.OFF_INTENT)
               // intentToService.putExtra("AlarmId", intentToService.getStringExtra("AlarmId"))
                startService(intentToService)
            }
        }

    }


    // criaçao da tabela memory q mosta as posiçoes(for em kotlin)

    private fun showToMemorize(time: Long, arrayToUse: ByteArray) {
        //  Log.e("antes", arrayToUse.toCollection(ArrayList()).toString())
        for (i in 0..15) {

            if (arrayToUse[i].toInt() == 1) {
                getBtnByPosition(i).setBackgroundResource(R.drawable.memory_game_btn_bg_green)
                // Log.e("depois", arrayToUse.toCollection(ArrayList()).toString())

            }
        }
        Handler().postDelayed({
            changeTableColor(R.drawable.memory_game_btn_bg_gray)

            setOnClick()
        }, time)


    }


    private fun getBtnByPosition(btnPosition: Int): Button {
        when (btnPosition) {
            0 -> return btn1
            1 -> return btn2
            2 -> return btn3
            3 -> return btn4
            4 -> return btn5
            5 -> return btn6
            6 -> return btn7
            7 -> return btn8
            8 -> return btn9
            9 -> return btn10
            10 -> return btn11
            11 -> return btn12
            12 -> return btn13
            13 -> return btn14
            14 -> return btn15
            else -> return btn16
        }
    }


    private fun setOnClick() {
        btn1.setOnClickListener {
            validateMemory(0)
        }
        btn2.setOnClickListener {
            validateMemory(1)
        }
        btn3.setOnClickListener {
            validateMemory(2)
        }
        btn4.setOnClickListener {
            validateMemory(3)
        }
        btn5.setOnClickListener {
            validateMemory(4)
        }
        btn6.setOnClickListener {
            validateMemory(5)
        }
        btn7.setOnClickListener {
            validateMemory(6)
        }
        btn8.setOnClickListener {
            validateMemory(7)
        }
        btn9.setOnClickListener {
            validateMemory(8)
        }
        btn10.setOnClickListener {
            validateMemory(9)
        }
        btn11.setOnClickListener {
            validateMemory(10)
        }
        btn12.setOnClickListener {
            validateMemory(11)
        }
        btn13.setOnClickListener {
            validateMemory(12)
        }
        btn14.setOnClickListener {
            validateMemory(13)
        }
        btn15.setOnClickListener {
            validateMemory(14)
        }
        btn16.setOnClickListener {
            validateMemory(15)
        }

    }


    private fun createViewByLayout() {

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
    }


    private fun changeTableColor(color: Int) {
        for (i in 0..15) {
            getBtnByPosition(i).setBackgroundResource(color)
        }

    }

    private fun startGameByLevel(level: Int) {


        if (level == 0) {
            arrayToUse = getRandonEasyArray()
            showToMemorize(1500, arrayToUse)

        } else {
            arrayToUse = getRandonHardArray()
            showToMemorize(1500, arrayToUse)
        }

    }

    private fun checkDone(level: Int): Boolean {
        if ((level == 0 && count == 4) || level == 1 && count == 7)
            return true
        return false
    }


}
