package com.fjln1920

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fjln1920.smarclock.Adapter.GameLevelAdapter
import com.fjln1920.smarclock.Models.GameLevel
import com.fjln1920.smarclock.R
import com.fjln1920.smarclock.database.DataBaseManager

class GameLevelSettings : AppCompatActivity() {





    private lateinit var gameLayoutManager: RecyclerView.LayoutManager
    private lateinit var gameLavelAdapter: RecyclerView.Adapter<*>
    private lateinit var gameLavelRecycleView: RecyclerView


    private lateinit var  title: TextView

    var equationLevelList =  listOf(
        GameLevel("Equation Level", "Easy", 15, "16 + 5"),
        GameLevel("Equation Level", "Hard", 30, "3x = 12"))



    var typeLevelList =  listOf(
        GameLevel("Type Level", "Easy", 10, "NHKJN"),
        GameLevel("Type Level", "Hard", 20, "xvJKH123#"))


    var memoryLevelList =  listOf(
        GameLevel("Memory Level", "Easy", 10, "Remember 4 cards"),
        GameLevel("Memory Level", "Hard", 20, "Remember 7 cards"))

    var shapeLevelList =  listOf(
        GameLevel("Shape Sequence Level", "Easy", 10, ""),
        GameLevel("Shape Sequence Level", "Hard", 20, ""))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_level_settings)


        title =  findViewById(R.id.text_game_level_title)



        gameLayoutManager = LinearLayoutManager(this)
        gameLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        initAdapter()

        gameLavelRecycleView = findViewById<RecyclerView>(R.id.game_level_recycle_view).apply {
            setHasFixedSize(true)
            layoutManager = gameLayoutManager
            adapter = gameLavelAdapter

        }







    }


    fun initAdapter() {


        when {
            intent.getStringExtra("option").equals("equation") -> {
                gameLavelAdapter = GameLevelAdapter(equationLevelList, this)
                title.text =  equationLevelList[0].title

            }
            intent.getStringExtra("option").equals("type") -> {
                gameLavelAdapter = GameLevelAdapter(typeLevelList, this)
                title.text =  typeLevelList[0].title

            }
            intent.getStringExtra("option").equals("memory") -> {
                gameLavelAdapter = GameLevelAdapter(memoryLevelList, this)
                title.text =  memoryLevelList[0].title
            }
            intent.getStringExtra("option").equals("shape") -> {
                gameLavelAdapter = GameLevelAdapter(shapeLevelList, this)
                title.text =  shapeLevelList[0].title
            }
        }


    }
}
