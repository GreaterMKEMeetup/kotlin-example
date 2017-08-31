package org.gmjm.kotlinexample.basics.kotlin.functions

import junit.framework.Assert.assertEquals
import org.junit.Test


// https://kotlinlang.org/docs/reference/functions.html

// No semi colon needed
// No declared return type, defautls to Unit
fun greetA(subject: String) = {
    println("Welcome, " + subject)
}

// No return type of void needed
fun greetB(subject: String) = "Welcome, " + subject

fun greetC(subject: String) = {
    "Welcome, " + subject
}

class Tests {

    @Test
    fun testA() {
        greetA("Meetup Members")
    }

    @Test
    fun testB() {
        println(greetB("Meetup Members"))
    }

    @Test
    fun gotcha() {
        val subject: String = "Meetup Members";

        assertEquals("Gotcha! greetC does not infer return type, and defualts to Unit.", greetB(subject), greetC(subject));
    }

}


class TestExtensions {


    fun String.greet(): String = "Hello, " + this;

    @Test
    fun testGreetingExtension() {
        println("Newman".greet());
    }


    // let's say you don't like using the '+' operator or .plus method on Int

    infix fun Int.addEmTogether(x:Int): Int = this.plus(x)

    @Test
    fun testAdd() {
        println(3 addEmTogether 5)
        println(3 addEmTogether 5 addEmTogether 6)
    }


}

