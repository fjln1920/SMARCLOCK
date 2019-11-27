package com.fjln1920.smarclock.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import  android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import com.fjln1920.smarclock.R
import java.util.*
import kotlin.concurrent.schedule

class Repeat : AppCompatActivity() {

    private lateinit var shapeImg: ImageView
    private lateinit var gridLayout: View
    private lateinit var circle: ImageView
    private lateinit var square: ImageView
    private lateinit var triagle: ImageView
    private lateinit var cruz: ImageView

    private val sequence1: ByteArray = byteArrayOf(0,1, 2, 3)
    private val sequence2: ByteArray = byteArrayOf(2, 3, 1, 0)
    private val sequence3: ByteArray = byteArrayOf(0, 3, 2, 1)
    private val sequence4: ByteArray = byteArrayOf(0, 1, 3, 2)

    private val shapeArray: IntArray = intArrayOf(
        R.drawable.ic_circle,
        R.drawable.ic_square,
        R.drawable.ic_triangle,
        R.drawable.ic_x
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repeat)
        shapeImg = findViewById(R.id.repeat_shape_image_big)
        gridLayout = findViewById(R.id.gridlayout)
        circle =  findViewById(R.id.circle)
        square =  findViewById(R.id.square)
        triagle =  findViewById(R.id.triangle)
        cruz =  findViewById(R.id.cruz)
        //shapeImg.setImageResource(R.drawable.ic_circle)
        var arrayToUse = getRandonSequenceArray()

        showToMemorize(1500, arrayToUse)

        verify(arrayToUse)



    }


    fun changeByShapeIndex(shape: Int, time: Long) {
        Handler().postDelayed({
            shapeImg.setImageResource(shapeArray[shape])
        }, time)

    }


    private fun showToMemorize(time: Long, arrayToUse: ByteArray) {

        shapeImg.setImageResource(shapeArray[arrayToUse[0].toInt()])
        Handler().postDelayed({
            Log.e("ok", "ok")
        }, 1500)

        for (index in 1..3)
            changeByShapeIndex(arrayToUse[index].toInt(), (time+index*time))

        Handler().postDelayed({
            shapeImg.visibility =  View.GONE

        },6*time-500)

        Handler().postDelayed({

            gridLayout.visibility =  View.VISIBLE
        },7*time-500)



    }


    private fun getRandonSequenceArray(): ByteArray {
        return when ((0..3).random()) {
            0 -> sequence1
            1 -> sequence2
            2 -> sequence3
            else -> sequence4
        }

    }

    private fun verify(arrayToUse: ByteArray){
        var index = 0

        if (index < 4){
            circle.setOnClickListener {
                if (arrayToUse[index].toInt() ==0){
                    circle.setBackgroundResource(R.color.colorGreen)
                    index++
                }

            }


            square.setOnClickListener {
                if (arrayToUse[index].toInt() ==1){
                    square.setBackgroundResource(R.color.colorGreen)
                    index++
                }

            }
            triagle.setOnClickListener {
                if (arrayToUse[index].toInt() ==2){
                    triagle.setBackgroundResource(R.color.colorGreen)
                    index++
                }

            }

            cruz.setOnClickListener {
                if (arrayToUse[index].toInt() ==3){
                    cruz.setBackgroundResource(R.color.colorGreen)
                    index++
                }

            }
        }

    }






}
