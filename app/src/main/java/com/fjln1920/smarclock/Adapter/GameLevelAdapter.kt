package com.fjln1920.smarclock.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fjln1920.smarclock.Models.Alarm
import com.fjln1920.smarclock.Models.GameLevel
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.AlarmLabelColor
import kotlinx.android.synthetic.main.game_level_item.view.*
import kotlinx.android.synthetic.main.home_alarm_item.view.*


class GameLevelAdapter(private var gameLavelList: List<GameLevel>, private val contex: Context) :
    RecyclerView.Adapter<GameLevelAdapter.GameLevelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameLevelViewHolder {
        return GameLevelViewHolder(
            LayoutInflater.from(contex).inflate(
                R.layout.game_level_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return gameLavelList.size
    }

    override fun onBindViewHolder(holder: GameLevelViewHolder, position: Int) {
        holder.txtLevel.text = gameLavelList.get(position).gameLevel.toString()
        holder.txtTime.text=gameLavelList.get(position).time.toString()
        holder.txtExample.text=gameLavelList.get(position).example.toString()
        holder.txtTimes.text = gameLavelList.get(position).times.toString()


    }


    class GameLevelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtLevel = view.text_level as TextView
        var txtTime = view.text_time as TextView
        var txtExample = view.text_example as TextView
        var txtTimes = view.text_times as TextView
        var btnTryIt = view.text_try_it as Button
    }
}