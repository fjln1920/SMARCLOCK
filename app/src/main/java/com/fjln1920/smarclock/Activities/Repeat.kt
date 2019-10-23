package com.fjln1920.smarclock.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import  android.os.Handler
import android.widget.Toast
import androidx.constraintlayout.solver.widgets.Helper
import androidx.core.os.postDelayed
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.Utils
import java.util.*

class Repeat : AppCompatActivity() {

    private lateinit var shapeImg: ImageView
    private var shapeSequence = intArrayOf(0,1,2,3);


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repeat)




        shapeImg = findViewById(R.id.repeat_shape_image_big)


        var i=0
        while (i<4){



                if (i == 0)
                    shapeImg.setImageResource(R.drawable.ic_circle)
                if (i == 1)
                    shapeImg.setImageResource(R.drawable.ic_triangle)
                if (i == 2)
                    shapeImg.setImageResource(R.drawable.ic_square)
                if (i == 3)
                    shapeImg.setImageResource(R.drawable.ic_x)
        
            i-=-1
        }

    }





}
