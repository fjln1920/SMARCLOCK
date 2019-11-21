package com.fjln1920

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fjln1920.smarclock.Adapter.GameLevelAdapter
import com.fjln1920.smarclock.Models.GameLevel
import com.fjln1920.smarclock.R

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class     GameLevelSettings : AppCompatActivity() {




    var gameAdded :  String = ""


    private lateinit var gameLayoutManager: RecyclerView.LayoutManager
    private lateinit var gameLavelAdapter: RecyclerView.Adapter<*>
    private lateinit var gameLavelRecycleView: RecyclerView


    private lateinit var  title: TextView

    private var equationLevelList =  listOf(
        GameLevel("Equation Level", "Easy", 15, "16 + 5", "eq"),
        GameLevel("Equation Leve", "Hard", 30, "3x = 12", "eq"))



    private var typeLevelList =  listOf(
        GameLevel("Type Level", "Easy", 10, "NHKJN", "ty"),
        GameLevel("Type Leve", "Hard", 20, "xvJKH123#", "ty"))


    private var memoryLevelList =  listOf(
        GameLevel("Memory Level", "Easy", 10, "Remember 4 cards", "me"),
        GameLevel("Memory Leve", "Hard", 20, "Remember 7 cards","me"))

    private var shapeLevelList =  listOf(
        GameLevel("Shape Sequence Level", "Easy", 10, "", "sh"),
        GameLevel("Shape Sequence Level", "Hard", 20, "", "sh"))


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





       // gameAdded = addGameFilter()







    }


    private fun initAdapter() {

        Log.e("ok", "ya")

        when {
            intent.getStringExtra("option") == "equation" -> {
                gameLavelAdapter = GameLevelAdapter(equationLevelList, this)
                title.text =  equationLevelList[0].title

            }
            intent.getStringExtra("option") == "type" -> {
                gameLavelAdapter = GameLevelAdapter(typeLevelList, this)
                title.text =  typeLevelList[0].title

            }
            intent.getStringExtra("option") == "memory" -> {
                gameLavelAdapter = GameLevelAdapter(memoryLevelList, this)
                title.text =  memoryLevelList[0].title
            }
            intent.getStringExtra("option") == "shape" -> {
                gameLavelAdapter = GameLevelAdapter(shapeLevelList, this)
                title.text =  shapeLevelList[0].title
            }
        }


    }


    override fun onStart() {
        super.onStart()
        initAdapter()
        Log.e("ahha", "kkk")
    }







}
