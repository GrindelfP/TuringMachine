package to.grindelf.turingmachine

import to.grindelf.turingmachine.TapeConstants.EMPTY_CHAR

class Tape(private val limitation: TapeLimitation,
                private val alphabet: Alphabet,
                initialSize: Int) {

    private val tapeText: MutableList<Char> = mutableListOf()
    private var size: Int = 0

    init {
        repeat(initialSize) {
            tapeText.add(EMPTY_CHAR)
        }
    }

    fun pointer(index: Int) = tapeText[index]

    fun writeToTape(word: String, index: Int) {


        when (index) {
            0 -> {
                for (i in word.indices) {
                    if (i >= size) {
                        size++

                    }
                    tapeText[i] = word[i]
                }
            }
        }
    }
}

class Alphabet(initialCharacters: MutableList<Char>) {

    private val characters: MutableList<Char> = mutableListOf('0')

    init {
        initialCharacters.sort()
        if (initialCharacters.contains(EMPTY_CHAR)) initialCharacters.removeAll(listOf(EMPTY_CHAR))
        characters.addAll(initialCharacters)
        characters.toList()
    }

    fun getCharacterIndex(character: Char): Int = characters.indexOf(character)

    operator fun get(index: Int) = characters[index]
}

enum class TapeLimitation(val value: String) {
    LIMITLESS("limitless"),
    LEFT_LIMITED("left-limited"),
    RIGHT_LIMITED("right-limited")
}

object TapeConstants {
    const val EMPTY_CHAR = '0'
}
