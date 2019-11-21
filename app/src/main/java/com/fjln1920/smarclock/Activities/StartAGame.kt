package com.fjln1920.smarclock.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.fjln1920.Settings
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.Constants
import com.fjln1920.smarclock.service.AlarmService

class StartAGame : AppCompatActivity() {

    private lateinit var txtTitle: TextView
    private lateinit var txtTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_agame)

        txtTime = findViewById(R.id.txt_time)
        txtTitle = findViewById(R.id.txt_title)
        Log.e("time", intent.getStringExtra("time"))

        txtTitle.text = intent.getStringExtra("title")
        txtTime.text = intent.getStringExtra("time")
         val intentToService  = Intent(this, AlarmService::class.java)
        intentToService.putExtra("ON_OFF", Constants.ADD_INTENT)
        intentToService.putExtra("AlarmId", intentToService.getStringExtra("AlarmId"))

        startService(intentToService)




    }
}
