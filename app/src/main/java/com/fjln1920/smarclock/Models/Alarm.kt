package com.fjln1920.smarclock.Models

import android.media.Ringtone
import com.fjln1920.smarclock.Utils.AlarmLabelColor
import com.fjln1920.smarclock.Utils.WeekDays
import java.io.Serializable

class Alarm: Serializable{

    // var hour: String


    //private var repeatTime: Int

    //private var vibrate: Boolean

   // private var deleteAfterOff: Boolean

    internal var labelColor: String

    private  var weekDays: String? = null


    private var id: Long = 0           // alarm's id this was create at the adding time
    private var hour_x: Int = 0         // alarm's hour
    private var minute_x: Int = 0       // alarm's minute
    private var alarm_title: String? = null  // alarm's name
    private var onOff: Int = 0          // alarm's on off


    constructor(
        id: Long,
        hour_x: Int,
        minute_x: Int,
        alarm_title: String?,
        labelColor: String,
        weekDays: String,
        onOff: Int
    ) {
        this.labelColor = labelColor
        this.weekDays = weekDays
        this.id = id
        this.hour_x = hour_x
        this.minute_x = minute_x
        this.alarm_title = alarm_title
        this.onOff = onOff
    }

    constructor(
        hour_x: Int,
        minute_x: Int,
        alarm_title: String?,
        labelColor: String,
        weekDays: String,
        onOff: Int
    ) {
        this.labelColor = labelColor
        this.weekDays = weekDays
        this.hour_x = hour_x
        this.minute_x = minute_x
        this.alarm_title = alarm_title
        this.onOff = onOff
    }

    fun getId(): Long {
        return id.toLong()
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getHour_x(): Int {
        return hour_x
    }

    fun setHour_x(hour_x: Int) {
        this.hour_x = hour_x
    }

    fun getMinute_x(): Int {
        return minute_x
    }

    fun setMinute_x(minute_x: Int) {
        this.minute_x = minute_x
    }

    fun getAlarm_title(): String {
        return this.alarm_title!!
    }

    fun setAlarm_title(alarm_Name: String) {
        this.alarm_title = alarm_Name
    }

    fun getOnOff(): Int {
        return onOff
    }

    fun setOnOff(onOff: Int) {
        this.onOff = onOff
    }


    fun setLabelColof(labelColor: String) {
        this.labelColor = labelColor
    }

    fun getAlarm_LabelColor(): String {
        return labelColor.toString()
    }


    fun getAlarm_WeekDays(): String{
        return this.weekDays!!
    }



    fun setAlarm_WeekDays(weekDays: String) {
        this.weekDays = weekDays
    }

    override fun toString(): String {
        return "Alarm(labelColor='$labelColor', weekDays=$weekDays, id=$id, hour_x=$hour_x, minute_x=$minute_x, alarm_title=$alarm_title, onOff=$onOff)"
    }


}