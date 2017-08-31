package org.gmjm.kotlinexample.basics.kotlin.classes

import org.junit.Test

// https://kotlinlang.org/docs/reference/classes.html

class BasicA {

}

// Multiple class definitions per file!
// Classes are "final" by default, open allows them to be extended.
open class BasicB {

}

class BasicC : BasicB() {

}

// Constructors
// https://kotlinlang.org/docs/reference/classes.html#constructors
// This is a "primary constructor"
class Greeting(greeting: String) {

    val greeting: String = greeting;

    // primary constructor cannot contain code.  Initialization code must be done here.
    init {
        println("Created new greeting with default: " + greeting)
    }

    fun greet(subject: String) = println(greeting + ", " + subject);

}

class Test1 {
    @Test
    fun test() {

        val greetingA = Greeting("Good morning")

        greetingA.greet("Howard")

    }
}

// constructors can be referenced by name, and have default values.
class EZGreet(timeOfDay: String = "morning", adjective: String = "terrible" ) {

    val timeOfDay: String = timeOfDay;
    val adjective: String = adjective;

    fun greet(subject: String) = println(adjective + " " + timeOfDay + ", " + subject);

}

class Test2 {
    @Test
    fun test() {

        val defaultGreeting = EZGreet()

        val specificGreeting = EZGreet("afternoon")

        val moreSpecificGreeting = EZGreet("afternoon", "Lovely")

        val mixedUpGreeting = EZGreet(
                adjective = "Lovely",
                timeOfDay = "afternoon")

        val timeOfDayOnlyGreeting = EZGreet(
                adjective = "Lovely")

        defaultGreeting.greet("Howard")
        specificGreeting.greet("Howard")
        moreSpecificGreeting.greet("Howard")
        mixedUpGreeting.greet("Howard")
        timeOfDayOnlyGreeting.greet("Howard")

    }

}

// https://kotlinlang.org/docs/reference/data-classes.html
data class Example(
        val a: String,  // Immutable, non null String
        var b: String,  // Mutable, non null String
        val c: String?, // Immutable, nullable String
        var d: String?) // Mutable, nullable String

class Test3 {

    @Test
    fun test_toString() {

        val example: Example = Example("a","b","c","d")

        // Auto toString
        println(example)

        // this will not compile
        //example.a = "b"

        // this will compile
        example.b = "bar"

        // this will not compile
        //example.b = null

        // this will compile
        example.d = null

        println(example)
    }

    @Test
    fun test_EqualsAndHashCode() {

        val exampleA: Example = Example("a","b","c","d")
        val exampleB: Example = Example("a","b","c","d")

        println(exampleA == exampleB) // true
        println(exampleA === exampleB) // false
        println(exampleA.equals(exampleB)) // true
        println("${exampleA.hashCode()}:${exampleB.hashCode()}")
        println("${exampleA.hashCode()}:${exampleB.hashCode()}")

        println("exampleB.d = \"e\"")
        exampleB.d = "e"

        println(exampleA == exampleB) // true
        println(exampleA === exampleB) // false
        println(exampleA.equals(exampleB)) // true
        println("${exampleA.hashCode()}:${exampleB.hashCode()}")
    }

    @Test
    fun testCopy() {

        val exampleA: Example = Example("a","b","c","d")
        val exampleB: Example = exampleA.copy()

        println("A: $exampleA")
        println("B: $exampleB")
        println()
        println("== ${exampleA == exampleB}") // true
        println("=== ${exampleA === exampleB}") // false
        println("A.equals(B) ${exampleA.equals(exampleB)}") // true
        println("${exampleA.hashCode()}:${exampleB.hashCode()}")

        println()
        println("exampleB.d = \"e\"")
        exampleB.d = "e"

        println()
        println("A: $exampleA")
        println("B: $exampleB")
        println()
        println("== ${exampleA == exampleB}") // true
        println("=== ${exampleA === exampleB}") // false
        println("A.equals(B) ${exampleA.equals(exampleB)}") // true
        println("${exampleA.hashCode()}:${exampleB.hashCode()}")
    }
}


