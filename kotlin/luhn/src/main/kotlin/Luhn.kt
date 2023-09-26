object Luhn {

  private val DIGITS_AND_SPACES = Regex("^[\\d\\s]*$")

  fun isValid(candidate: String): Boolean = with(candidate.normalizeCandidate()) {
    isDigitsAndSpaces(candidate)
        && isValidLength()
        && isValidFormat()
        && isValidCheckSum()
  }

  private fun String.normalizeCandidate(): String = this.filter { it.isDigit() }

  private fun isDigitsAndSpaces(candidate: String): Boolean = candidate.matches(DIGITS_AND_SPACES)

  private fun String.isValidLength(): Boolean = this.length > 1

  private fun String.isValidFormat(): Boolean = this.all { it.isDigit() }

  private fun String.isValidCheckSum(): Boolean {
    val checkSum = this.map { it.toString().toInt() }
      .mapIndexed { index, digit ->
        if ((this.length - index) % 2 == 0) digit.doubleWithSubtraction()
        else digit
      }.sum()
    return checkSum % 10 == 0
  }

  private fun Int.doubleWithSubtraction() : Int = when (val doubled = this * 2) {
    in 0..9 -> doubled  // Return doubled if it's less than 9
    else -> doubled - 9 // Subtract 9 otherwise
  }
}
