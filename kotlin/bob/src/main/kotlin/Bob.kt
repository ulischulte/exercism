object Bob {
  private const val SHOUTING = "(?=.*[A-Z])(^[A-Z\\d\\s,!:^%@'#*&$()?]*)"

  fun hey(input: String): String = when {
    input.isBlank() -> "Fine. Be that way!"
    input.trim().matches(Regex(SHOUTING)) && input.isQuestion() -> "Calm down, I know what I'm doing!"
    input.isQuestion() -> "Sure."
    input.matches(Regex(SHOUTING)) -> "Whoa, chill out!"
    else -> "Whatever."
  }

  private fun String.isQuestion(): Boolean = this.trim().endsWith("?")
}
