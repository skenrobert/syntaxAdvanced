package com.example.syntaxadvanced

class Designer(name: String, age: Int): Person(name, age) {

    override fun work() {
        println("This person is designing")
        super.work()
    }

}