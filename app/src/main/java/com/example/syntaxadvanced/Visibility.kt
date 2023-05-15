package com.example.syntaxadvanced

private class Visibility { // no access out this file, because is private

    var name: String? = null

    private fun sayMyName() {// in the cause than class is public this function no access out this file
        name?.let {
            println("My name is $it")
        } ?: run {
            println("I do not have a name")
        }
    }

}

open class VisibilityTwo { // access visibility class because is the same file

    protected fun sayMyNameTwo() { //It works as private unless it is a sub-class

        val visibility = Visibility() // this is visibility into the same file
        visibility.name = "Robert"
    }

}

// no need stay in the same file with protected, only import than to be sub-class
class VisibilityThree: VisibilityTwo() { //It a sub-class them sayMyNameTwo is visibility for it

    internal val age: Int? = null // (internal) this last modifiers only look at, for this project, in the cause than other project use this module no have access this value

    fun sayMyNameThree() {
        sayMyNameTwo()
    }

}