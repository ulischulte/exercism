class PhoneNumber(numberString: String) {
  val number: String

  init {
    val digitsFromNumberString = numberString.filter { it.isDigit() }
    val nanpNumber = digitsFromNumberString.let {
      if (it.length == 11 && it.first() == '1') it.drop(1)
      else it
    }
    validateNumberLength(nanpNumber)
    validateFirstDigit(nanpNumber)
    validateAreaCode(nanpNumber)
    validateOnlyValidCharsArePresent(nanpNumber)

    number = nanpNumber
  }

  private fun validateNumberLength(number: String) = require(number.length in arrayOf(10, 11))

  private fun validateFirstDigit(number: String) =
    if (number.length == 10) {
      require(number.first().digitToInt() > 1)
    } else {
      require(number.first().digitToInt() == 1)
    }

  private fun validateAreaCode(number: String) = require(number[number.length - 7].digitToInt() > 1)

  private fun validateOnlyValidCharsArePresent(number: String) = require(number.matches(Regex("[^\\p{L}\\p{P}]*")))
}
