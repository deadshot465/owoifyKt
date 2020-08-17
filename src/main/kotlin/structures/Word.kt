package structures

class Word(word: String) {
    var word = word
    val replacedWords = mutableSetOf<String>()

    fun replace(searchValue: Regex, replaceValue: String, replaceReplacedValue: Boolean = false): Word {

    }

    fun replace(searchValue: Regex, func: () -> String, replaceReplacedValue: Boolean): Word {

    }

    fun replace(searchValue: Regex, func: (String, String) -> String, replaceReplacedValue: Boolean): Word {

    }
}