package com.example.syntaxadvanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.syntaxadvanced.ui.theme.SyntaxAdvancedTheme

//add for practice
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

//lesson 7
typealias MyMapList = MutableMap<Int, ArrayList<String>>
typealias MyFun = (Int, String, MyMapList) -> Boolean
typealias MyNestedClass = MyNestedAndInnerClass.MyNestedClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SyntaxAdvancedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }



                // Enum Classes
               // enumClasses()

                // Nested and Inner Classes
                //nestedAndInnerClasses()

                // Class Inheritance
               //classInheritance()

                // Interfaces
                //interfaces()

                // Visibility Modifiers
                //visibilityModifiers()

                // Data classes
                //dataClasses()

                // Type aliases
                //typeAliases()

                // Destructuring declarations
                //destructuringDeclarations()

                // Extensions
                //extensions()

                // Lambdas
                lambdas()
            }
        }
    }
}

enum class Direction(val dir: Int) {

    NORTH(1), SOUTH(-1), EAST(1), WEST(-1); //declare value constant, avoid fail in your variables

    fun description(): String {// add function enum
        return when (this) {
            NORTH -> "The address is north"
            SOUTH -> "The address is south"
            EAST -> "The address is this"
            WEST -> "The address is west"
        }
    }

}

private fun enumClasses() {

    // Securities assignment
    var userDirection: Direction? = null
    println("Address: $userDirection")

    userDirection = Direction.NORTH
    println("Address: $userDirection")

    userDirection = Direction.WEST
    println("Address: $userDirection")

    // Default properties
    println("Property name: ${userDirection.name}") //the last value name designate
    println("Property ordinal: ${userDirection.ordinal}") //the position with enum last println value

    // Functions
    println(userDirection.description()) //function associate last value name indicate

    // Initialization
    println(userDirection.dir)// value dir declare in the class enum, the last value

    println(Direction.values().size) // size the enum class
    println(Direction.valueOf("SOUTH" ).description()) //worker in specific value

}

// Lesson 2 nested and inner class

private fun nestedAndInnerClasses() {

    // Class nested
    val myNestedClass = MyNestedClass() //not instance same as inner
    val sum = myNestedClass.sum(10, 5)
    println("The solve of the sum is $sum")

    // Class inner
    val myInnerClass = MyNestedAndInnerClass().MyInnerClass() //not instance same as nested, look at two ().()
    val sumTwo = myInnerClass.sumTwo(10)
    println("The result of adding two is $sumTwo")
}

// Lesson 3  Class Inheritance

private fun classInheritance() {

    val person = Person("kenny", 40)

    val programmer = Programmer("robert", 36, "Kotlin")
    programmer.work()
    programmer.sayLanguage()
    programmer.goToWork()
    programmer.drive()

    val designer = Designer("peter", 30)
    designer.work()
    designer.goToWork()
}

// Lesson 4: Interfaces
// always the interfaces is uses through The a class (any) than declared
private fun interfaces() {

    val gamer = Person("Benny", 36)
    gamer.play()
    gamer.stream()
}

// Lesson 5 Visibility Modifiers, is only 4:
// Private
// Protected
// Internal
// Public (default for all declared)
private fun visibilityModifiers() {

    //val visibility = Visibility() // not instance because is private
    //visibility.name = "MORA" // no assigned because the class is private
    //visibility.sayMyName() // not instance because is private

    val visibilityTwo = VisibilityTwo()
    //visibilityTwo.sayMyNameTwo()
}

// Lección 6: Data Classes

private fun dataClasses() {

    val sken = Worker("kenny robert", 35, "devops")
    sken.lastWork = "developer"

    val sara = Worker()

    val other = Worker("robert kenny", 35, "devops")
    other.lastWork = "devops"

    // equals & hashCode
//    if (sken == other) {
    if (sken.equals(other)) {// other form to do behind
        println("They are equal")
    } else {
        println("They are not the same ")
    }

    // toString
    println(sken.toString())

    // copy
    val other2 = sken.copy(age = 34)
    println(sken.toString())
    println(other2.toString())

    // componentN
    val (name, age) = other
    println(name)
    println(age)
}

// Lesson 7: Type aliases

private var myMap: MyMapList = mutableMapOf()

private fun typeAliases() {

    val myNewMap: MyMapList = mutableMapOf()
    myNewMap[1] = arrayListOf("robert", "kenny")
    myNewMap[2] = arrayListOf("mora", "parra")

    myMap = myNewMap
}

// Lesson 8: Destructuring declarations

private fun destructuringDeclarations() {

    val (name, _, work) = Worker("Robert Mora", 34, "Developer")
    println("$name, $work") // not access age but _, in cause do you need

    val const1 = Worker("Kenny Parra", 34, "Developer")
    println(const1.component1())// same $name example behind
    println(const1.component2())// same $age example behind
    println(const1.component3())//same $work example behind

    val (nameWorker, ageWorker) = myWorker()
    println("$nameWorker, $ageWorker")

    // map is element have a key and value identical a json but no equal
    val myMap = mapOf(1 to "Kenny", 2 to "Ana", 3 to "Sara")
    for ((id, name) in myMap) { //optimize loop maps
        println("$id, $name")
    }
}

private fun myWorker(): Worker {
    return Worker("KENNY ROBERT", 36, "developer")
}

// Lección 9 Kotlin Intermedio: Extensions

private fun extensions() {

    val myDate = Date()
    println(myDate.customFormat())
    println(myDate.formatSize)

    var myDateNullable: Date? = null
    println(myDateNullable.customFormat())
    println(myDateNullable.formatSize)
}

// Lesson 10: Lambdas

private fun lambdas() {

    val myIntList = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val myFilterIntList = myIntList.filter { myInt ->

        println(myInt) //print all array
        if (myInt == 1) { //always into add 1, to myFilterIntList
            return@filter true
        }

        myInt > 5// only add value greater than 5
    }
    println(myFilterIntList)

    val mySumFun = fun (x: Int, y: Int): Int = x + y
    val myMultFun = fun (x: Int, y: Int): Int = x * y

    myAsyncFun("Kenny") {
        println(it)
    }

    println(myOperateFun(5, 10, mySumFun))
    println(myOperateFun(5, 10, myMultFun))
    println(myOperateFun(5, 10) { x, y -> x - y })
}

private fun myOperateFun(x: Int, y: Int, myFun: (Int, Int) -> Int): Int {
    return myFun(x, y)
}

private fun myAsyncFun(name: String, hello: (String) -> Unit) {
    val myNewString = "Hello $name!"
    thread {
        Thread.sleep(5000)
        hello(myNewString)
    }

    thread {
        Thread.sleep(1000)
        hello(myNewString)
    }

    thread {
        Thread.sleep(7000)
        hello(myNewString)
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SyntaxAdvancedTheme {
        Greeting("Android")
    }
}