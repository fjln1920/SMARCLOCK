package com.fjln1920.smarclock.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import  android.os.Handler
import android.os.Looper
import android.util.Log
import com.fjln1920.smarclock.R
import java.util.*
import kotlin.concurrent.schedule

class Repeat : AppCompatActivity() {

    private lateinit var shapeImg: ImageView
    private val sequence1: ByteArray = byteArrayOf(0,1, 2, 3)
    private val sequence2: ByteArray = byteArrayOf(2, 3, 1, 0)
    private val sequence3: ByteArray = byteArrayOf(0, 3, 2, 1)
    private val sequence4: ByteArray = byteArrayOf(0, 1, 3, 2)

    private val shapeArray: IntArray = intArrayOf(
        R.drawable.ic_circle,
        R.drawable.ic_square,
        R.drawable.ic_triangle,
        R.drawable.ic_x
    ) s


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repeat)
        shapeImg = findViewById(R.id.repeat_shape_image_big)
        //shapeImg.setImageResource(R.drawable.ic_circle)
        var arrayToUse = getRandonSequenceArray()
        showToMemorize(3000, arrayToUse)




    }


    fun changeByShapeIndex(shape: Int) {
        shapeImg.setImageResource(shapeArray[shape])
    }


    private fun showToMemorize(time: Long, arrayToUse: ByteArray) {



    }


    private fun getRandonSequenceArray(): ByteArray {
        return when ((0..3).random()) {
            0 -> sequence1
            1 -> sequence2
            2 -> sequence3
            else -> sequence4
        }

    }


}
