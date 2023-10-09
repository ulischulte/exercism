object Series {
  fun slices(lengthOfSlices: Int, digitsString: String): List<List<Int>> {
    validateInput(lengthOfSlices, digitsString)
    val sliceIndicesRange = 0 until (digitsString.length - lengthOfSlices + 1)
    return sliceIndicesRange.map { index -> sliceToDigitList(digitsString, index, lengthOfSlices) }
  }

  private fun validateInput(lengthOfSlices: Int, digitsString: String) {
    require(
      lengthOfSlices > 0 &&
          digitsString.isNotBlank() &&
          digitsString.all { it.isDigit() } &&
          lengthOfSlices <= digitsString.length
    )
  }

  private fun sliceToDigitList(digitsString: String, startIndex: Int, lengthOfSlices: Int): List<Int> {
    return digitsString.substring(startIndex until startIndex + lengthOfSlices).toIntList()
  }

  private fun String.toIntList(): List<Int> = this.map { it.digitToInt() }
}
