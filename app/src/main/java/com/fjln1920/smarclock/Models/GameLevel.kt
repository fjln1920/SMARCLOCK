package com.fjln1920.smarclock.Models

import kotlin.properties.Delegates

class GameLevel {
     lateinit var  title: String;
     lateinit var  gameLavel: GameLevel
     var time by Delegates.notNull<Int>()

      lateinit var example: String
     var times by Delegates.notNull<Int>()


    constructor(title: String, gameLavel: GameLevel, time: Int, example: String, times: Int) {
        this.title = title
        this.gameLavel = gameLavel
        this.time = time
        this.example = example
        this.times = times
    }
}