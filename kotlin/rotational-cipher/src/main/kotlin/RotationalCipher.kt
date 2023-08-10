class RotationalCipher(key: Int) {
  private val shiftKey: Int

  init {
    require(key in 0..26) { "Key must be between 0 and 26" }
    shiftKey = key
  }

  fun encode(text: String): String {
    return text.map { char ->
      when {
        char.isUpperCase() -> rotate(char, 'A')
        char.isLowerCase() -> rotate(char, 'a')
        else -> char
      }
    }.joinToString("")
  }

  private fun rotate(c: Char, zeroPoint: Char): Char {
    return ((c - zeroPoint + shiftKey) % 26 + zeroPoint.code).toChar()
  }
}
