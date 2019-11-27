package com.fjln1920

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fjln1920.smarclock.R

class ChooseAGame : AppCompatActivity() {


    private lateinit var btnEquationOption: View
    private lateinit var btnTyoeOption: View
    private lateinit var btnMemoryOption: View
    private lateinit var btnShapeOption: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_agame)




        btnEquationOption =  findViewById(R.id.equation_layout)
        btnEquationOption.setOnClickListener {
            var intent =  Intent(this, GameLevelSettings::class.java)
            intent.putExtra("option", "equation")
            startActivity(intent)
        }



        btnTyoeOption =  findViewById(R.id.type_password_layout)
        btnTyoeOption.setOnClickListener {
            var intent =  Intent(this, GameLevelSettings::class.java)
            intent.putExtra("option", "type")
            startActivity(intent)
        }


        btnMemoryOption =  findViewById(R.id.memory_layout)
        btnMemoryOption.setOnClickListener {
            var intent =  Intent(this, GameLevelSettings::class.java)
            intent.putExtra("option", "memory")
            startActivity(intent)
        }


        btnShapeOption =  findViewById(R.id.shape_sequence_layout)
        btnShapeOption.setOnClickListener {
            var intent =  Intent(this, GameLevelSettings::class.java)
            intent.putExtra("option", "shape")
            startActivity(intent)
        }
    }
}
