object ScrabbleScore {

    private val letterScores = mapOf(
        'Q' to 10, 'Z' to 10,
        'J' to 8, 'X' to 8,
        'K' to 5,
        'F' to 4, 'H' to 4, 'V' to 4, 'W' to 4, 'Y' to 4,
        'B' to 3, 'C' to 3, 'M' to 3, 'P' to 3,
        'D' to 2, 'G' to 2
    )

    fun scoreWord(input: String) = input.sumOf { letterScores[it.uppercaseChar()] ?: 1 }
}
