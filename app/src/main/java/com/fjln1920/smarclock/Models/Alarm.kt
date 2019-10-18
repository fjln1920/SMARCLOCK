package com.fjln1920.smarclock.Models

import android.media.Ringtone
import com.fjln1920.smarclock.Utils.AlarmLabelColor
import com.fjln1920.smarclock.Utils.WeekDays

class Alarm {

    internal var hour: String

    internal var title: String

    private var ringtone: String

    private var repeatTime: Int

    private var vibrate: Boolean

    private var deleteAfterOff: Boolean

    internal var labelColor: AlarmLabelColor

    private var weekDays: List<WeekDays>


    constructor(
        hour: String,
        title: String,
        ringtone: String,
        repeatTime: Int,
        vibrate: Boolean,
        deleteAfterOff: Boolean,
        labelColor: AlarmLabelColor,
        weekDays: List<WeekDays>
    ) {
        this.hour = hour
        this.title = title
        this.ringtone = ringtone
        this.repeatTime = repeatTime
        this.vibrate = vibrate
        this.deleteAfterOff = deleteAfterOff
        this.labelColor = labelColor
        this.weekDays = weekDays
    }



}