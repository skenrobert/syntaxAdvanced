package com.example.syntaxadvanced

// check Work() is a class, and Game is a Interface
open class Person(name: String, age: Int) : Work(), Game { // default class is closed, for them add open in start

    // Any kind has a common superclass "Any", is for default example .toString()

    open fun work() { // add open in start allow change this function in it's son
        println("This person is working")
    }

    override fun goToWork() { //add override in start change this function inherited, comes from class Work
        println("This person goes to work")
    }

    // Game Interface
    override val game: String = "Among Us" //add override in start change this attrib inherited

    // this function no have default behavior because is declared here, from interfaces Game
    override fun play() { // //add override in start change this function inherited
        println("This person is playing $game")
    }

}