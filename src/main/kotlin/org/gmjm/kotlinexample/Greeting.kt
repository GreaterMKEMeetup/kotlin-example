package org.gmjm.kotlinexample.greeting

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

fun sayHello(subject: String): String {
    return "Hello, $subject"
}

data class Data(val a: Int, val b: Int)

@RestController
class GreetingController {

    val random: Random = Random()

    @GetMapping("/greeting")
    fun getHello(@RequestParam(value = "subject", defaultValue = "World")subject: String): String {
        return "Hello, $subject"
    }

    @GetMapping("/data")
    fun getData(@RequestParam(value = "subject", defaultValue = "World")subject: String): Data {
        return Data(random.nextInt(),random.nextInt())
    }

}

