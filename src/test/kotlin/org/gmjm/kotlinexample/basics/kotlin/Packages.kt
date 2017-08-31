// package declaration Does not have to match directory structure.
package totally.different.than.directory

import org.junit.Test

// Import aliases!  This is SUPER useful
import java.lang.String as SillyOrderedCharacterHolder


class Tests {

    @Test
    fun test() {

        val subject: SillyOrderedCharacterHolder = SillyOrderedCharacterHolder("Moto")

        println("Hello, " + subject)
    }

}