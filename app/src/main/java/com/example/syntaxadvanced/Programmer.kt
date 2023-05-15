package com.example.syntaxadvanced

class Programmer(name: String, age: Int, val language: String): Person(name, age), Vehicle {

    override fun work() {//add override in start change this function inherited
        println("This person is programming")
//        super.work()  //in the cases do you need call function original of the father
    }

    fun sayLanguage() { // this function is property this class
        println("This programmer uses language $language")
    }

    override fun goToWork() { //add override in start change this function inherited
        println("This person goes to Google")
    }

    override fun drive() {
        println("This person drives a car")
    }

}