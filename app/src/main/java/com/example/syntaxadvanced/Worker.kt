package com.example.syntaxadvanced

data class Worker(val name: String = "", val age: Int = 0, val work: String = "") {//property obligatory, in the moment to create,
    // or no change because when create have value for default and not variable (var) They are constant (val)

    var lastWork: String = "" //property not obligatory
}