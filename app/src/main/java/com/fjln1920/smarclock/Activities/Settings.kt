package com.fjln1920


import android.app.Dialog
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fjln1920.smarclock.R



class Settings : AppCompatActivity() {

    private lateinit var backBtn: ImageButton
    private lateinit var title_text: TextView
    private lateinit var btn_save: Button
    private lateinit var alarm_text: String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)



        backBtn = findViewById(R.id.setting_back_btn)
        title_text = findViewById(R.id.title_text)
        btn_save = findViewById(R.id.setting_save_alarm_btn)

        backBtn.setOnClickListener {
            intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }

        btn_save.setOnClickListener {

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
            alarm_text = edt_alarm_title.text.toString()
            title_text.text = alarm_text
            dialog.dismiss()
        }

        dialog.show()

        val display = (getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay
        val width = display.width


        dialog.window!!.setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT)

    }










}
