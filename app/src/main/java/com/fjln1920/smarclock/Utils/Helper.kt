package com.fjln1920.smarclock.Utils

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.View
import com.fjln1920.GameLevelSettings

class Helper {


  //  public static var gameAdded: String = ""


    fun getRandString(list: List<String>, range: Int): String {
        val rndIndex = (0 until range).random()
        return list[rndIndex]

    }


    fun getRandEquationKey(list: List<String>, range: Int): String {
        val rndIndex = (0 until range).random()
        return list[rndIndex]

    }


    fun retryGame(view: View) {
        Handler().postDelayed({
            view.visibility = View.GONE

        }, 2000)

    }


    fun returnToTryIt(view: View, context: Context, option: String) {
        Handler().postDelayed({
            view.visibility = View.GONE
            var intent = Intent(context, GameLevelSettings::class.java)
            context.startActivity(intent)
            intent.putExtra("option", option)

        }, 1500)
    }


    fun addGameFilter( toFilter: String, toAddIn: String): String{
        if(!toAddIn.contains(toFilter))
            return toAddIn + toFilter
        else return toAddIn
    }

}