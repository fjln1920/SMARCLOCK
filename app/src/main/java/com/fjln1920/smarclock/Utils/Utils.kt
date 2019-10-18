package com.fjln1920.smarclock.Utils

import java.util.*

class Utils {


    fun <T> Array<T>.shuffle(): Array<T> {
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