package org.gmjm.kotlinexample.basics.kotlin.recursion

import org.junit.Test
import java.math.BigInteger

tailrec fun toZeroRecursive(bigInteger: BigInteger) {
    if (bigInteger.mod(BigInteger("1000")) == BigInteger.ZERO) {
        println(bigInteger)
    }

    if (bigInteger.compareTo(BigInteger.ZERO) > 0) {
        toZeroRecursive(bigInteger.subtract(BigInteger.ONE))
    }
}

// https://kotlinlang.org/docs/reference/functions.html#tail-recursive-functions
class TailRecursiveTest {


    @Test
    fun test() {
        toZeroRecursive(BigInteger("700000"))
    }

}