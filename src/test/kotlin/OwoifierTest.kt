import io.github.deadshot465.owoify.Owoifier
import io.github.deadshot465.owoify.OwoifyLevel
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class OwoifierTest {
    private val source = "Hello World! This is the string to owo! Kinda cute, isn't it?"

    @Test fun testOwoify() {
        assertNotEquals(Owoifier.owoify(source), source)
    }

    @Test fun testOwo() {
        assertNotNull(Owoifier.owoify(source))
    }

    @Test fun testUwu() {
        assertNotNull(Owoifier.owoify(source, OwoifyLevel.Uwu))
    }

    @Test fun testUvu() {
        assertNotNull(Owoifier.owoify(source, OwoifyLevel.Uvu))
    }

    @Test fun testOwoNotEqualToUwu() {
        assertNotEquals(Owoifier.owoify(source), Owoifier.owoify(source, OwoifyLevel.Uwu))
    }

    @Test fun testOwoNotEqualToUvu() {
        assertNotEquals(Owoifier.owoify(source), Owoifier.owoify(source, OwoifyLevel.Uvu))
    }

    @Test fun testUwuNotEqualToUvu() {
        assertNotEquals(Owoifier.owoify(source, OwoifyLevel.Uwu), Owoifier.owoify(source, OwoifyLevel.Uvu))
    }
}