package org.gmjm.kotlinexample.nulls

import org.junit.Test

class KotlinExamples_nullable {
   data class Person (
        var name: String? = null,
        var email: String? = null,
        var address: Address? = null)

    data class Address (
        var streetAddress: String? = null,
        var city: String? = null,
        var state: State? = null,
        var country: String? = null)

   data class State (
        var fullName: String? = null,
        var abbreviation: String? = null)


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

        println(unsafeToString(contact));

        contact.address?.state = null;

        println(unsafeToString(contact));
    }

    fun unsafeToString(contact: Person): String {
        return "name: ${contact.name}, email: ${contact.email}, city: ${contact.address?.city}, state: ${contact.address?.state?.fullName}";
    }
}
