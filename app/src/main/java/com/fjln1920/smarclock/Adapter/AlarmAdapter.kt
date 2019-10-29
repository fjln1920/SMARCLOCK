package com.fjln1920.smarclock.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fjln1920.smarclock.Models.Alarm
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.AlarmLabelColor
import kotlinx.android.synthetic.main.home_alarm_item.view.*


class AlarmAdapter(private var alarmList: ArrayList<Alarm>, private val contex: Context) :
    RecyclerView.Adapter<AlarmViewHolder>() {

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
        holder.alarmHour.text = alarmList.get(position).hour
        holder.alarmTitle.text = alarmList.get(position).title

        if (alarmList.get(position).labelColor == AlarmLabelColor.BLUE)
            holder.alarmLabelColor.setBackgroundResource(R.drawable.alarm_item_blue_label)
        else if (alarmList.get(position).labelColor == AlarmLabelColor.RED)
            holder.alarmLabelColor.setBackgroundResource(R.drawable.alarm_item_red_label)
        else
            holder.alarmLabelColor.setBackgroundResource(R.drawable.alarm_item_green_label)

    }

    fun removeAt(position: Int) {
        alarmList.removeAt(position)
        notifyItemRemoved(position)
    }


}


class AlarmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var alarmLabelColor = view.alarm_item_label_color as View
    var alarmHour = view.alarm_item_hour as TextView
    var alarmWeekDay = view.alarm_item_week_days as TextView
    var alarmTitle = view.alarm_item_title as TextView
}