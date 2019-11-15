package com.fjln1920.smarclock.Utils

import android.view.MenuItem
import com.fjln1920.smarclock.Models.Alarm

interface AlarmCalback {


    //Callback xử lý logic start alarm
    fun startAlarm(timeItem: Alarm)

    //Callback xử lý logic cancel alarm
    fun cancelAlarm(timeItem: Alarm)

}