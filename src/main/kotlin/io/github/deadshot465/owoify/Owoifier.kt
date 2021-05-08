package io.github.deadshot465.owoify

import io.github.deadshot465.owoify.structures.Word
import io.github.deadshot465.owoify.utility.*

/**
 * The main entry point of Owoify.
 * Invoke Owoifier.owoify() to owoify an arbitrary string.
 */
object Owoifier {
    private val wordRegex = Regex("[^\\s]+")
    private val spaceRegex = Regex("\\s+")

    /**
     * The primary and the only function in Owoifier object.
     * @param source The source string to owoify.
     * @param level Optional. Specifies the owoness level.
     * @return The owoified string.
     */
    fun owoify(source: String, level: OwoifyLevel = OwoifyLevel.Owo): String {
        val wordMatches = wordRegex.findAll(source)
        val spaceMatches = spaceRegex.findAll(source)
        var words = wordMatches.map { Word(it.groups[0]!!.value) }
        val spaces = spaceMatches.map { Word(it.groups[0]!!.value) }

        words = words.map(fun (w: Word): Word {
            var innerWord = w
            for (func in SPECIFIC_WORD_MAPPING_LIST) {
                innerWord = func(innerWord)
            }
            when (level) {
                OwoifyLevel.Owo -> {
                    for (func in OWO_MAPPING_LIST) {
                        innerWord = func(innerWord)
                    }
                }
                OwoifyLevel.Uwu -> {
                    for (func in UWU_MAPPING_LIST) {
                        innerWord = func(innerWord)
                    }
                    for (func in OWO_MAPPING_LIST) {
                        innerWord = func(innerWord)
                    }
                }
                OwoifyLevel.Uvu -> {
                    for (func in UVU_MAPPING_LIST) {
                        innerWord = func(innerWord)
                    }
                    for (func in UWU_MAPPING_LIST) {
                        innerWord = func(innerWord)
                    }
                    for (func in OWO_MAPPING_LIST) {
                        innerWord = func(innerWord)
                    }
                }
            }
            return innerWord
        })

        val result = interleaveArrays(words, spaces)
        val resultStrings = result.map { w -> w.toString() }
        return resultStrings.joinToString("")
    }
}