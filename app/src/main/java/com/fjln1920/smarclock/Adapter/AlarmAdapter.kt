package com.fjln1920.smarclock.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fjln1920.smarclock.Models.Alarm
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.AlarmCalback
import com.fjln1920.smarclock.Utils.AlarmLabelColor
import kotlinx.android.synthetic.main.home_alarm_item.view.*


class AlarmAdapter(private var alarmList: ArrayList<Alarm>, private val contex: Context, private val calback: AlarmCalback) :
    RecyclerView.Adapter<AlarmViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        return AlarmViewHolder(
            LayoutInflater.from(contex).inflate(
                R.layout.home_alarm_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return alarmList.size
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.alarmHour.text = getStringFromTime(alarmList[position])
        holder.alarmTitle.text = alarmList.get(position).getAlarm_title()
        holder.alarmWeekDay.text =  alarmList.get(position).getAlarm_WeekDays()
        calback.startAlarm(alarmList[position])
        calback.cancelAlarm(alarmList[position])

        if (alarmList.get(position).getAlarm_LabelColor() == AlarmLabelColor.BLUE.toString())
            holder.alarmLabelColor.setBackgroundResource(R.drawable.alarm_item_blue_label)
       else if (alarmList.get(position).getAlarm_LabelColor() == AlarmLabelColor.RED.toString())
           holder.alarmLabelColor.setBackgroundResource(R.drawable.alarm_item_red_label)
       else
            holder.alarmLabelColor.setBackgroundResource(R.drawable.alarm_item_green_label)




    }

    fun removeAt(position: Int) {
        alarmList.removeAt(position)
        notifyItemRemoved(position)
    }



    // TODO: 6/15/2018 return string from Alarm
    private fun getStringFromTime(alarm: Alarm): String {

        val minute = alarm.getMinute_x() // minute of alarm
        val hourSource = alarm.getHour_x() // hour of alarm
        val hour: Int // this hold time for time at AM, PM format
        val hour_x: String // append 0 in front of hour if hour less than 10
        val minute_x: String // append 0 in front of minute if minute less than 10
        val format: String      // format for alarm


        if (hourSource == 0) {
            hour = hourSource + 12
            format = "AM"
        } else if (hourSource == 12) {
            hour = hourSource
            format = "PM"
        } else if (hourSource > 12) {
            hour = hourSource - 12
            format = "PM"
        } else {
            hour = hourSource
            format = "AM"
        }


        if (hour < 10) {
            hour_x = "0$hour"
        } else {
            hour_x = "" + hour
        }

        if (minute < 10) {
            minute_x = "0$minute"
        } else {
            minute_x = "" + minute
        }


        return "$hour_x : $minute_x    $format"
    }


}


class AlarmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var alarmLabelColor = view.alarm_item_label_color as View
    var alarmHour = view.alarm_item_hour as TextView
    var alarmWeekDay = view.alarm_item_week_days as TextView
    var alarmTitle = view.alarm_item_title as TextView




}