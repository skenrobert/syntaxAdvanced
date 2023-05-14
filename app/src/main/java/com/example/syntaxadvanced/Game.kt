package com.example.syntaxadvanced

interface Game { // always need called by class for used

    val game: String // Not having a default behavior should be declared in the class that instantiates it

    // not need open in the start because not default behavior
    fun play() // Not having a default behavior should be declared in the class that instantiates it

    fun stream() { // this having a default behavior, not need declared in the class than instantiates it
        println("I'm streaming my game $game")
    }

}