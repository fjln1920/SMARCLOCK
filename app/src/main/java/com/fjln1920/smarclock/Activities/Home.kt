package com.fjln1920

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import com.fjln1920.smarclock.database.DataBaseManager
import com.fjln1920.smarclock.receiver.AlarmReceiver

class Home : AppCompatActivity(), AlarmCalback {


    private lateinit var alarmLayoutManager: RecyclerView.LayoutManager
    private lateinit var alarmAdapter: RecyclerView.Adapter<*>
    private lateinit var alarmRecycleView: RecyclerView
    private lateinit var relativeLayout: RelativeLayout
    private lateinit var btnAdd: Button




    // this to manage data base
    private lateinit var dataBaseManager: DataBaseManager
    var alarmList = ArrayList<Alarm>()


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        dataBaseManager = DataBaseManager(this)
        relativeLayout = findViewById(R.id.activityMain)
        alarmLayoutManager = LinearLayoutManager(this)
        alarmLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        importData()


        alarmRecycleView = findViewById<RecyclerView>(R.id.alarms_recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = alarmLayoutManager
            adapter = alarmAdapter

        }
        alarmRecycleView.overScrollMode = View.OVER_SCROLL_NEVER

        btnAdd = findViewById(R.id.home_add_alarm_btn)
        btnAdd.setOnClickListener {
            intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }


        val swipeHandler = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = alarmRecycleView.adapter as AlarmAdapter
                dataBaseManager.delete(alarmList[viewHolder.adapterPosition].getId())
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


    // TODO: import data from dataBase and create AlarmAdapter
    private fun importData() {
        // alarmAdapter = AlarmAdapter(alarmList, this)
        // initialize database manager
        dataBaseManager = DataBaseManager(this)
        // get Alarm ArrayList from database
        alarmList = dataBaseManager.alarmList
        // create Alarm adapter to display detail through RecyclerView
        alarmAdapter = AlarmAdapter(alarmList, this, this)
    }


    // TODO: this sends intent to AlarmReceiver
    private fun sendIntent(alarm: Alarm, intentType: String) {
        // intent1 to send to AlarmReceiver
        val intent1 = Intent(this@Home, AlarmReceiver::class.java)
        // put intent type Constants.ADD_INTENT or Constants.OFF_INTENT
        intent1.putExtra("intentType", intentType)
        // put alarm'id to compare with pendingIntent'id in AlarmService
        intent1.putExtra("AlarmId", alarm.getId().toInt())
        intent1.putExtra("title", alarm.getAlarm_title())
        intent1.putExtra("time", alarm.getHour_x().toString()+":"+alarm.getMinute_x())
        // this sent broadCast right a way
        sendBroadcast(intent1)
    }


    // TODO: this sets pendingIntent for alarm
    private fun setAlarm(alarm: Alarm, flags: Int) {
        // this set alarm based on TimePicker so we need to set Calendar like the
        // trigger time
        // get instant of Calendar
        val myCalendar = java.util.Calendar.getInstance()
        val calendar = myCalendar.clone() as java.util.Calendar
        // set current hour for calendar
        calendar.set(java.util.Calendar.HOUR_OF_DAY, alarm.getHour_x())
        // set current minute
        calendar.set(java.util.Calendar.MINUTE, alarm.getMinute_x())
        // set current second for calendar
        calendar.set(java.util.Calendar.SECOND, 0)
        // plus one day if the time set less than the the Calendar current time
        if (calendar.compareTo(myCalendar) <= 0) {
            calendar.add(java.util.Calendar.DATE, 1)
        }
        // get id of alarm and set for PendingIntent to multiply multiple PendingIntent for cancel
        // time, this also put into PendingIntent to compare with the cancel Alarm's id=
        val alarmId = alarm.getId()
        // make intent to broadCast
        //AlarmReceiver.intentOK =  intentStopACtivity
        val intent = Intent(this@Home, AlarmReceiver::class.java)

        // put intent type to check which intent trigger add or cancel
        intent.putExtra("intentType", Constants.ADD_INTENT)
        // put id to intent
        intent.putExtra("PendingId", alarmId)
        // this pendingIntent include alarm id  to manage
        val alarmIntent = PendingIntent.getBroadcast(
            this@Home, alarmId.toInt(),
            intent, flags
        )
        // create alarm manager ALARM_SERVICE
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        // Set alarm, at the trigger time "calandar.getTimeInMillis" this pendingIntent will be
        // sent to AlarmReceiver and then sent to alarm service to play music
        // this "AlarmManager.INTERVAL_DAY" mean this will set one new alarm at the trigger time
        // setInExactRepeating this may set alarm again and again also this may be not
        // trigger at the right time( at the first second start) but this will save the battery.
        // "AlarmManager.RTC_WAKEUP" allow this app wake device from idle time and the time
        // based on device time

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis, AlarmManager.INTERVAL_DAY, alarmIntent
        )




    }

    override fun startAlarm(timeItem: Alarm) {
        //TODO: Xử lý truyền thông tin giờ hẹn cho AlarmReceiver
        // when toggle button click on set alarm on
        timeItem.setOnOff(1)
        // update database
        dataBaseManager.update(timeItem)
        // set PendingIntent for this alarm
        setAlarm(timeItem, 0)

    }


    override fun cancelAlarm(timeItem: Alarm) {

        //TODO: Gửi thông tin giờ hẹn cần hủy sang cho AlarmReceiver
        // when user click cancel toggle button
        // set alarm off
        //timeItem.setOnOff(0)
        // update database
        //dataBaseManager.update(timeItem)
        // cancel this Alarm PendingIntent
        // deleteCancel(timeItem)
        // if alarm is triggered and ringing, send this alarm detail to AlarmReceiver
        // then AlarmReceiver send detail to service to stop music
        sendIntent(timeItem, Constants.OFF_INTENT)

    }


    // TODO:  this cancel pendingIntent of the alarm
    private fun deleteCancel(alarm: Alarm) {
        // if user click delete or cancel alarm the pendingIntent also to be canceled by AlarmManager
        // this PendingIntent is canceled based on alarm's ID was set for it, the pendingIntent is
        // going to be canceled must be same with the one was made based on it'id and intent also
        // where the context is.
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        // get alarm id
        val alarmId = alarm.getId().toInt()
        // create intent
        val intent = Intent(this@Home, AlarmReceiver::class.java)
        // this retrieve the pendingIntent was set
        val alarmIntent = PendingIntent.getBroadcast(this@Home, alarmId, intent, 0)
        // cancel this pendingIntent
        alarmManager.cancel(alarmIntent)
    }


}
