package com.fjln1920


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.fjln1920.smarclock.Models.Alarm
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.AlarmLabelColor
import com.fjln1920.smarclock.Utils.WeekDays
import com.fjln1920.smarclock.database.DataBaseManager


class Settings : AppCompatActivity() {


    // view contents
    private lateinit var backBtn: ImageButton
    private lateinit var title_text: TextView
    private lateinit var btn_save: Button


    private lateinit var btnChooseAGame: Button



    private lateinit var alarmTimePiker: TimePicker

    
    
    // weekDay
    private lateinit var btnM: TextView
    private lateinit var btnT: TextView
    private lateinit var btnW: TextView
    private lateinit var btnTh: TextView
    private lateinit var btnF: TextView
    private lateinit var btnSu: TextView
    private lateinit var btnS: TextView


    private  var weekDays: String = "Everyday"
    private  var alarm_title: String = "No Title"


    // this to manage data base
    private lateinit var dataBaseManager: DataBaseManager
    private lateinit var alarm: Alarm















    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
//        ButterKnife.bind(this)



        backBtn = findViewById(R.id.setting_back_btn)
        title_text = findViewById(R.id.title_text)
        btn_save = findViewById(R.id.setting_save_alarm_btn)
        alarmTimePiker =  findViewById(R.id.alarm_settings_time_piker)


        initWeakDayBtns()

        backBtn.setOnClickListener {
            intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }

        btn_save.setOnClickListener {
            intent = Intent(this, Home::class.java)
            startActivity(intent)
            dataBaseManager = DataBaseManager(this)
            Log.e("hour",  alarmTimePiker.hour.toString())
            val rndIndex = (0 until 3).random()
            var collor = "";
            if (rndIndex == 0){
                collor =  AlarmLabelColor.BLUE.toString()
            }else if(rndIndex ==1){
                collor =  AlarmLabelColor.RED.toString()
            }else{
                collor =  AlarmLabelColor.GREEN.toString()
            }
            alarm =  Alarm(System.currentTimeMillis(), alarmTimePiker.hour, alarmTimePiker.minute, alarm_title, collor, weekDays, 1)
            dataBaseManager.insert(alarm)



        }

        btnChooseAGame =  findViewById(R.id.btn_choose_a_game)

        btnChooseAGame.setOnClickListener{
            var intent: Intent =  Intent(this, ChooseAGame::class.java)
            this.startActivity(intent)

        }


        title_text.setOnClickListener {
            showDialog()
        }
    }


    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_alarm_title_dialog)
        dialog.getWindow()!!.setBackgroundDrawableResource(android.R.color.transparent);


        val edt_alarm_title = dialog.findViewById(R.id.edt_alarm_title) as EditText


        val dialogButton = dialog.findViewById(R.id.btn_save_title) as Button
        dialogButton.setOnClickListener {
            alarm_title = edt_alarm_title.text.toString()
            title_text.text = alarm_title
            dialog.dismiss()
        }

        dialog.show()

        val display = (getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay
        val width = display.width


        dialog.window!!.setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT)

        
        
    }
    
    
    private fun initWeakDayBtns(){
        btnM =  findViewById(R.id.monday_btn)
        btnT =  findViewById(R.id.tuesday_btn)
        btnTh =  findViewById(R.id.thursday_btn)
        btnS =  findViewById(R.id.saturday_btn)
        btnF =  findViewById(R.id.friday_btn)
        btnSu =  findViewById(R.id.sunday_btn)
        btnW =  findViewById(R.id.wednesday_btn)
        setWeekDayBybtn("m",btnM )
        setWeekDayBybtn("t",btnT )
        setWeekDayBybtn("w",btnW )
        setWeekDayBybtn("th",btnTh )
        setWeekDayBybtn("f",btnF )
        setWeekDayBybtn("s",btnS )
        setWeekDayBybtn("su",btnSu )
    }
    
    

    private fun setWeekDayBybtn(day: String, btn: TextView){
        btn.setOnClickListener {
            if (weekDays.equals("Everyday")){
              weekDays = ""
            }
            weekDays+= "$day,"
            btn.setTextColor(resources.getColor(R.color.colorGreen))
        }
    }














}
