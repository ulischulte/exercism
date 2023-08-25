object Bob {
    private const val SHOUTING = "(?=.*[A-Z])(?!^\\s*\$)^[^a-z]+\$"
    private const val SHOUTING_QUESTION = "^(?=.*[A-Z])[A-Z\\s]*\\?$"

    fun hey(input: String): String = when {
        input.matches(Regex(SHOUTING_QUESTION)) -> "Calm down, I know what I'm doing!"
        input.trim().endsWith("?") -> "Sure."
        input.matches(Regex(SHOUTING)) -> "Whoa, chill out!"
        input.isBlank() -> "Fine. Be that way!"
        else -> "Whatever."
    }
}
