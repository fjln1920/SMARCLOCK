package com.fjln1920

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fjln1920.smarclock.Adapter.AlarmAdapter
import com.fjln1920.smarclock.Models.Alarm
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.AlarmLabelColor
import com.fjln1920.smarclock.Utils.WeekDays

class Home : AppCompatActivity() {


    private lateinit var alarmLayoutManager: RecyclerView.LayoutManager
    private lateinit var alarmAdapter: RecyclerView.Adapter<*>
    private lateinit var alarmRecycleView: RecyclerView


    var alarmList = listOf<Alarm>(

        Alarm(
            "14:22", "Wake up", "gritos", 1, false, false, AlarmLabelColor.RED,
            listOf<WeekDays>(WeekDays.friday, WeekDays.monday)
        ),
        Alarm(
            "17:22", "Go to school", "gritos", 1, false, false, AlarmLabelColor.BLUE,
            listOf<WeekDays>(WeekDays.friday, WeekDays.monday)
        ),
        Alarm(
            "19:22", "Back to home", "gritos", 1, false, false, AlarmLabelColor.GREEN,
            listOf<WeekDays>(WeekDays.friday, WeekDays.monday)
        ),


        Alarm(
            "14:22", "Wake up", "gritos", 1, false, false, AlarmLabelColor.RED,
            listOf<WeekDays>(WeekDays.friday, WeekDays.monday)
        ),
        Alarm(
            "17:22", "Go to school", "gritos", 1, false, false, AlarmLabelColor.BLUE,
            listOf<WeekDays>(WeekDays.friday, WeekDays.monday)
        ),
        Alarm(
            "19:22", "Back to home", "gritos", 1, false, false, AlarmLabelColor.GREEN,
            listOf<WeekDays>(WeekDays.friday, WeekDays.monday)
        )


    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        alarmLayoutManager = LinearLayoutManager(this)
        alarmLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        alarmAdapter = AlarmAdapter(alarmList, this)

        alarmRecycleView = findViewById<RecyclerView>(R.id.alarms_recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = alarmLayoutManager
            adapter = alarmAdapter

        }

    }


}
