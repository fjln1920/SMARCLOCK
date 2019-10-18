package com.fjln1920.smarclock.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.Utils.Utils
import java.util.*

class Repeat : AppCompatActivity() {

    private lateinit var shapeImg: ImageView
    private var shapeSequence = intArrayOf(0,1,2,3);


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repeat)

        shapeSequence.shuffle()


        shapeImg = findViewById(R.id.repeat_shape_image_big)
        for (i in 0..3){
            if (i == 0)
                shapeImg.setImageResource(R.drawable.ic_circle)
            if (i == 2)
                shapeImg.setImageResource(R.drawable.ic_square)
        }

    }


    fun IntArray.shuffle(): IntArray {
        val rng = Random()

        for (index in 0..this.size - 1) {
            val randomIndex = rng.nextInt(index)

            // Swap with the random position
            val temp = this[index]
            this[index] = this[randomIndex]
            this[randomIndex] = temp
        }

        return this
    }

    

}
