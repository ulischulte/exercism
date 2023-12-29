object RunLengthEncoding {

    fun encode(input: String): String {
        // Regex pattern to match consecutive identical characters
        val consecutiveCharsPattern = Regex("(.)\\1+")

        // Replace matches in the input string with the length of the match
        // followed by the matched character
        return input.replace(consecutiveCharsPattern) { matchResult ->
            val char = matchResult.groupValues[1]
            val count = matchResult.value.length
            "$count$char"
        }
    }

    fun decode(input: String): String {
        // Regex pattern to match a number followed by a character
        val encodedPattern = Regex("(\\d+)(.)")

        // Replace matches in the input string with the character
        // repeated the number of times specified by the matched number
        return input.replace(encodedPattern) { matchResult ->
            val count = matchResult.groupValues[1].toInt()
            val char = matchResult.groupValues[2]
            char.repeat(count)
        }
    }
}
