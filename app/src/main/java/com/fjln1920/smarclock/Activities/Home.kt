package com.fjln1920

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fjln1920.smarclock.Adapter.AlarmAdapter
import com.fjln1920.smarclock.Models.Alarm
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.*

class Home : AppCompatActivity() {


    private lateinit var alarmLayoutManager: RecyclerView.LayoutManager
    private lateinit var alarmAdapter: RecyclerView.Adapter<*>
    private lateinit var alarmRecycleView: RecyclerView

    var notificationId = 0
    lateinit var relativeLayout: RelativeLayout
    private lateinit var btnAdd: Button




    var alarmList = arrayListOf<Alarm>(

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




    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        relativeLayout =  findViewById(R.id.activityMain)

        alarmLayoutManager = LinearLayoutManager(this)
        alarmLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        alarmAdapter = AlarmAdapter(alarmList, this)


        alarmRecycleView = findViewById<RecyclerView>(R.id.alarms_recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = alarmLayoutManager
            adapter = alarmAdapter

        }
        alarmRecycleView.overScrollMode = View.OVER_SCROLL_NEVER


        btnAdd = findViewById(R.id.home_add_alarm_btn)
        btnAdd.setOnClickListener {
           // intent = Intent(this, Settings::class.java)
            //intent.putExtra("id_value", id)
             //intent.putExtra("language_value", language)
           // startActivity(intent)


            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, 15)
                    set(Calendar.MINUTE, 3)
                    set(Calendar.SECOND, 0)
                }.timeInMillis,
                PendingIntent.getService(
                    applicationContext,
                    0,
                    Intent(applicationContext, AlarmBroadcastReceiver::class.java).apply {
                        putExtra("notificationId", ++notificationId)
                        putExtra("reminder", "okook")
                    },
                    PendingIntent.FLAG_CANCEL_CURRENT
                )
            )

            Toast.makeText(applicationContext, "SET!!", Toast.LENGTH_SHORT).show()
          //  reset()


        }


        val swipeHandler = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = alarmRecycleView.adapter as AlarmAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(alarmRecycleView)


    }




    override fun onTouchEvent(event: MotionEvent?): Boolean {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(relativeLayout.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        relativeLayout.requestFocus()
        Toast.makeText(applicationContext, "ok!!", Toast.LENGTH_SHORT).show()
        return super.onTouchEvent(event)
    }







}
