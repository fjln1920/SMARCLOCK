package com.fjln1920.smarclock.Utils

class Helper {


     fun getRandString (list: List<String>, range: Int): String {
        val rndIndex = (0 until range).random()
        return list[rndIndex]

    }


    fun getRandEquationKey  (list: List<String>, range: Int): String {
        val rndIndex = (0 until range).random()
        return list[rndIndex]

    }
}