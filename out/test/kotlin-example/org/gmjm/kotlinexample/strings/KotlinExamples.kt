package org.gmjm.kotlinexample.strings

import org.junit.Test
import java.time.OffsetDateTime

class KotlinExamples {


    data class Greeting(
            val subject: String,
            val author: String,
            val language: String,
            val integerNumber: Int,
            val decimalNumber: Float,
            val currentTime: OffsetDateTime = OffsetDateTime.now())

    @Test
    fun test() {

        val g = Greeting(
                "Meetup Attendees",
                "Andy Glassman",
                "Kotlin",
                523,
                3.4f,
                OffsetDateTime.now()

        )

        val synopsis =
                """
Hello ${g.subject},
    How are you today? My name is ${g.author}, and today I'll be teaching you
how to write templated strings in ${g.language}. It's easy they say!.
You can format:
    integers: ${g.integerNumber}
    integers(hex): ${g.integerNumber}
    decimals: ${g.decimalNumber}
    dates: ${g.currentTime}
You can also reference earlier arguments: ${g.language}!
"""
        println(synopsis)
    }


    @Test
    fun namedParameter_defaultParameter() {

        val g = Greeting(
                author = "Andy Glassman",
                subject = "Meetup Attendees",
                decimalNumber = 3.4f,
                integerNumber = 523,
                language = "Kotlin")

        val synopsis =
                """
Hello ${g.subject},
    How are you today? My name is ${g.author}, and today I'll be teaching you
how to write templated strings in ${g.language}. It's easy they say!.
You can format:
    integers: ${g.integerNumber}
    integers(hex): ${g.integerNumber}
    decimals: ${g.decimalNumber}
    dates: ${g.currentTime}
You can also reference earlier arguments: ${g.language}!
"""
        println(synopsis)
    }


    fun greet(g: Greeting): String {
        return (
                """
Hello ${g.subject},
    How are you today? My name is ${g.author}, and today I'll be teaching you
how to write templated strings in ${g.language}. It's easy they say!.
You can format:
    integers: ${g.integerNumber}
    integers(hex): ${g.integerNumber}
    decimals: ${g.decimalNumber}
    dates: ${g.currentTime}
You can also reference earlier arguments: ${g.language}!
""")
    }

    @Test
    fun greetFunction() {
        println(greet(Greeting(
                author = "Andy Glassman",
                subject = "Meetup Attendees",
                decimalNumber = 3.4f,
                integerNumber = 523,
                language = "Kotlin")))
    }
}
