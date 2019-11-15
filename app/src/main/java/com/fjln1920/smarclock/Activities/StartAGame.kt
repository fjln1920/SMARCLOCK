package com.fjln1920.smarclock.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fjln1920.Settings
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.Constants
import com.fjln1920.smarclock.service.AlarmService

class StartAGame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_agame)

         val intentToService  = Intent(this, AlarmService::class.java)
        intentToService.putExtra("ON_OFF", Constants.ADD_INTENT)
        intentToService.putExtra("AlarmId", intentToService.getStringExtra("AlarmId"))
        startService(intentToService)




    }
}
