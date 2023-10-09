object Series {
  fun slices(lengthOfSlices: Int, digitsString: String): List<List<Int>> {
    validateInput(lengthOfSlices, digitsString)
    return digitsString.map { it.toString().toInt() }.windowed(lengthOfSlices)
  }

  private fun validateInput(lengthOfSlices: Int, digitsString: String) {
    require(
      lengthOfSlices > 0 &&
          digitsString.isNotBlank() &&
          digitsString.all { it.isDigit() } &&
          lengthOfSlices <= digitsString.length
    )
  }

}
