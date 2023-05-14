package com.example.syntaxadvanced

class MyNestedAndInnerClass {

    private val one = 1 //only access for inner class

    private fun returnOne(): Int { //only access for inner class
        return one
    }

    //Nested Class
    class MyNestedClass { //not Inherits attributes (one), need Encapsulation for access attrib the father

        fun sum(first: Int, second: Int): Int {
            return first + second
        }
    }

    //Inner Class
    inner class MyInnerClass {  //Inherits attributes (one)

        fun sumTwo(number: Int): Int {// sum one 2 time, the value send from main
            return number + one + returnOne()
        }
    }

}