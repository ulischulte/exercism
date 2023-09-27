class PhoneNumber(numberString: String) {
  val number: String

  init {
    val nanpNumber = numberString.filter { it.isDigit() }.let {
      if (it.length == 11 && it.first() == '1') it.drop(1)
      else it
    }
    require(nanpNumber.length == 10)
    require(nanpNumber.first().digitToInt() > 1)
    require(nanpNumber[3].digitToInt() > 1)
    require(nanpNumber.matches(Regex("[^\\p{L}\\p{P}]*")))

    number = nanpNumber
  }
}
