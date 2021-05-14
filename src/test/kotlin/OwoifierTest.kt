import io.github.deadshot465.owoify.Owoifier
import io.github.deadshot465.owoify.OwoifyLevel
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Path

class OwoifierTest {
    private val source = "Hello World! This is the string to owo! Kinda cute, isn't it?"
    private val pokemonNamesListPath = "assets/pokemons.txt"
    private val warAndPeacePath = "assets/war_and_peace_chapter01-20.txt"
    private val pokemonNamesList = Files.readAllLines(Path.of(pokemonNamesListPath))
    private val warAndPeaceText = Files.readString(Path.of(warAndPeacePath))

    @Test fun testOwoify() {
        assertNotEquals(Owoifier.owoify(source), source)
    }

    @Test fun testOwo() {
        val text = Owoifier.owoify(source)
        assertNotEquals(text, "")
        assertNotNull(text)
    }

    @Test fun testUwu() {
        val text = Owoifier.owoify(source, OwoifyLevel.Uwu)
        assertNotEquals(text, "")
        assertNotNull(text)
    }

    @Test fun testUvu() {
        val text = Owoifier.owoify(source, OwoifyLevel.Uvu)
        assertNotEquals(text, "")
        assertNotNull(text)
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

    @Test fun testPokemonNames() {
        pokemonNamesList.forEach {
            val nameWithOwo = Owoifier.owoify(it)
            val nameWithUwu = Owoifier.owoify(it, OwoifyLevel.Uwu)
            val nameWithUvu = Owoifier.owoify(it, OwoifyLevel.Uvu)
            assertNotNull(nameWithOwo)
            assertNotNull(nameWithUwu)
            assertNotNull(nameWithUvu)
            assertNotEquals(nameWithOwo, "")
            assertNotEquals(nameWithUwu, "")
            assertNotEquals(nameWithUvu, "")
        }
    }

    @Test fun testLongText() {
        val textWithOwo = Owoifier.owoify(warAndPeaceText)
        val textWithUwu = Owoifier.owoify(warAndPeaceText, OwoifyLevel.Uwu)
        val textWithUvu = Owoifier.owoify(warAndPeaceText, OwoifyLevel.Uvu)
        assertNotNull(textWithOwo)
        assertNotNull(textWithUwu)
        assertNotNull(textWithUvu)
        assertNotEquals(textWithOwo, "")
        assertNotEquals(textWithUwu, "")
        assertNotEquals(textWithUvu, "")
    }
}