import structures.Word
import utility.*

object Owoifier {
    private val wordRegex = Regex("[^\\s]+")
    private val spaceRegex = Regex("\\s+")

    fun owoify(source: String, level: OwoifyLevel = OwoifyLevel.Owo): String {
        val wordMatches = wordRegex.findAll(source)
        val spaceMatches = spaceRegex.findAll(source)
        var words = wordMatches.map { it -> Word(it.groups[0]!!.value) }
        var spaces = spaceMatches.map { it -> Word(it.groups[0]!!.value) }

        words = words.map(fun (w: Word): Word {
            var _word = w
            for (func in SPECIFIC_WORD_MAPPING_LIST) {
                _word = func(_word)
            }
            when (level) {
                OwoifyLevel.Owo -> {
                    for (func in OWO_MAPPING_LIST) {
                        _word = func(_word)
                    }
                }
                OwoifyLevel.Uwu -> {
                    for (func in UWU_MAPPING_LIST) {
                        _word = func(_word)
                    }
                    for (func in OWO_MAPPING_LIST) {
                        _word = func(_word)
                    }
                }
                OwoifyLevel.Uvu -> {
                    for (func in UVU_MAPPING_LIST) {
                        _word = func(_word)
                    }
                    for (func in UWU_MAPPING_LIST) {
                        _word = func(_word)
                    }
                    for (func in OWO_MAPPING_LIST) {
                        _word = func(_word)
                    }
                }
            }
            return _word
        })

        val result = interleaveArrays(words, spaces)
        val resultStrings = result.map { w -> w.toString() }
        return resultStrings.joinToString("")
    }
}