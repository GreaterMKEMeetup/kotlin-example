package org.gmjm.kotlinexample.nulls

import org.junit.Test

class KotlinExamples_notNullable {
    data class Person (
        val name: String,
        val email: String,
        val address: Address)

    data class Address (
        val streetAddress: String,
        val city: String,
        val state: State,
        val country: String)

   data class State (
       val fullName: String,
       val abbreviation: String)


    @Test
    fun test_fullContact() {
        val contact =
                Person(
                        "Buster Bluth",
                        "buster@bluth.com",
                        Address(
                                "302 Sudden Valley Ct.",
                                "The OC",
                        State(
                                "California",
                                "CA"),
                        "USA"))

        println(contact);
    }
}
