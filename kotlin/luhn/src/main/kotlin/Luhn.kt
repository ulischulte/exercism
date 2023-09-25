object Luhn {
  fun isValid(candidate: String): Boolean {
    if (!candidate.matches(Regex("^[\\d\\s]*$"))) return false
    val normalizedCandidate = candidate.normalizeCandidate()
    return isValidLength(normalizedCandidate) && isValidFormat(normalizedCandidate) && isValidCheckSum(normalizedCandidate)
  }

  private fun isValidLength(candidate: String) = candidate.length > 1

  private fun isValidFormat(candidate: String) = candidate.all { it.isDigit() }

  private fun isValidCheckSum(candidate: String): Boolean {
    val digits = candidate.map { it.toString().toInt() }
    val checkSum = digits.mapIndexed { index, digit ->
      if ((digits.size - index) % 2 == 0) doubleWithSubtraction(digit) else digit
    }.sum()
    return checkSum % 10 == 0
  }

  private fun doubleWithSubtraction(digit: Int): Int {
    val doubled = digit * 2
    return if (doubled > 9) doubled - 9
    else doubled
  }

  private fun String.normalizeCandidate() = this.filter { it.isDigit() }
}
