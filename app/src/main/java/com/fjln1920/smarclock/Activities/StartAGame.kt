package com.fjln1920.smarclock.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.fjln1920.Settings
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.Constants
import com.fjln1920.smarclock.service.AlarmService

class StartAGame : AppCompatActivity() {

    private lateinit var txtTitle: TextView
    private lateinit var txtTime: TextView
    private lateinit var startGameBtn: Button
    private var level = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_agame)

        txtTime =  findViewById(R.id.txt_time)
        txtTitle =  findViewById(R.id.txt_title)
        val title = intent.getStringExtra("title")
        val time = intent.getStringExtra("time")
        Log.e("time", time+title)
        txtTitle.text = title
        txtTime.text = time
        val intentToService = Intent(this, AlarmService::class.java)
        intentToService.putExtra("ON_OFF", Constants.ADD_INTENT)
        intentToService.putExtra("AlarmId", intentToService.getStringExtra("AlarmId"))
        startService(intentToService)

        txtTime = findViewById(R.id.txt_time)
        txtTitle = findViewById(R.id.txt_title)
       // Log.e("time", intent.getStringExtra("time"))

        startGameBtn =  findViewById(R.id.start_game_btn)

        startGameBtn.setOnClickListener {
            startGame()
            level = (0 until 1).random()
        }





    }


    fun startGame() {
        val rndIndex = (0 until 2).random();
        when (rndIndex) {
            0 -> {
                intent = Intent(this, MemoryGame::class.java)
                intent.putExtra("level", level)
            }
            1 -> {
                intent = Intent(this, SolveEquation::class.java)
                intent.putExtra("level", level)
            }
            2 -> {
                intent = Intent(this, Type::class.java)
                intent.putExtra("level", level)
            }//if(rndIndex ==3)
            //  intent =  Intent(this, MemoryGame::class.java)
        }//if(rndIndex ==3)
        //  intent =  Intent(this, MemoryGame::class.java)
        startActivity(intent)
    }
}
