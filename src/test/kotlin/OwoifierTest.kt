import org.deadshot465.owoify.Owoifier
import org.deadshot465.owoify.OwoifyLevel
import org.junit.Assert.assertNotNull
import org.junit.Test

class OwoifierTest {
    @Test fun testOwoifier() {
        assertNotNull(Owoifier.owoify("This is the string to owo! Kinda cute isn't it?"))
        assertNotNull(Owoifier.owoify("This is the string to owo! Kinda cute isn't it?", OwoifyLevel.Uvu))
    }
}