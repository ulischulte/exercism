class RotationalCipher(private val shiftKey: Int) {

  init {
    require(shiftKey in 0..26) { "Key must be between 0 and 26" }
  }

  fun encode(text: String): String =
      text.map { char ->
        when {
          char.isUpperCase() -> rotate(char, 'A')
          char.isLowerCase() -> rotate(char, 'a')
          else -> char
        }
      }.joinToString("")

  private fun rotate(character: Char, zeroPoint: Char): Char =
      ((character - zeroPoint + shiftKey) % 26 + zeroPoint.code).toChar()
}
