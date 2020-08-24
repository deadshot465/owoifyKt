package structures

class Word(private var word: String) {
    private val replacedWords = mutableSetOf<String>()

    fun replace(searchValue: Regex, replaceValue: String, replaceReplacedWords: Boolean = false): Word {
        if (!replaceReplacedWords && searchValueContainsReplacedWords(searchValue, replaceValue)) {
            return this
        }
        var replacingWord = word
        if (searchValue.matches(word)) {
            replacingWord = searchValue.replace(word, replaceValue)
        }
        val collection = searchValue.findAll(word)
        var replacedWords = mutableListOf<String>()
        if (collection.count() > 1) {
            replacedWords = collection.map { it -> it.groups[0]!!.value.replace(it.groups[0]!!.value, replaceValue)}.toMutableList()
        }
        if (replacingWord != word) {
            for (_word in replacedWords) {
                this.replacedWords.add(_word)
            }
            word = replacingWord
        }
        return this
    }

    fun replace(searchValue: Regex, func: () -> String, replaceReplacedWords: Boolean): Word {
        val replaceValue = func()
        if (!replaceReplacedWords && searchValueContainsReplacedWords(searchValue, replaceValue)) {
            return this
        }
        var replacingWord = word
        if (searchValue.matches(word)) {
            val matchItem = searchValue.find(word)?.groups?.get(0)?.value
            replacingWord = word.replace(matchItem!!, replaceValue)
        }
        val collection = searchValue.findAll(word)
        var replacedWords = mutableListOf<String>()
        if (collection.count() > 1) {
            replacedWords = collection.map { it -> it.groups[0]!!.value.replace(it.groups[0]!!.value, replaceValue) }.toMutableList()
        }
        if (replacingWord != word) {
            for (_word in replacedWords) {
                this.replacedWords.add(_word)
            }
            word = replacingWord
        }
        return this
    }

    fun replace(searchValue: Regex, func: (String, String) -> String, replaceReplacedWords: Boolean): Word {
        if (!searchValue.matches(word)) {
            return this
        }
        val word = this.word
        val captures = searchValue.find(word)
        val replaceValue = func(captures!!.groups[1]!!.value, captures.groups[2]!!.value)
        if (!replaceReplacedWords && searchValueContainsReplacedWords(searchValue, replaceValue)) {
            return this
        }
        val replacingWord = this.word.replace(captures.groups[0]!!.value, replaceValue)
        val collection = searchValue.findAll(this.word)
        val replacedWords = if (collection.count() > 1) {
            collection.map { it -> it.groups[0]!!.value.replace(it.groups[0]!!.value, replaceValue) }.toMutableList()
        } else {
            mutableListOf()
        }
        if (replacingWord != this.word) {
            for (_word in replacedWords) {
                this.replacedWords.add(_word)
            }
            this.word = replacingWord
        }
        return this
    }

    private fun searchValueContainsReplacedWords(searchValue: Regex, replaceValue: String): Boolean {
        return replacedWords.any { s: String ->
            if (searchValue.matches(s)) {
                val matchResult = searchValue.find(s)?.groups?.get(0)?.value
                return s.replace(matchResult!!, replaceValue) == s;
            }
            return false
        }
    }

    override fun toString(): String {
        return word
    }
}