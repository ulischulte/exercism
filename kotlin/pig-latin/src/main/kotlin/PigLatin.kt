object PigLatin {

  private val TWO_LETTER_CLUSTERS = setOf(
    "bl", "br", "ch", "cl", "cr", "dr", "fl", "fr", "gl", "gr", "pl", "pr",
    "qu", "rh", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th",
    "tr", "tw", "wh", "wr"
  )

  private val THREE_LETTER_CLUSTERS = setOf("spl", "spr", "str", "scr", "shr", "squ", "thr", "sch")

  private val VOWEL_START_REGEX = Regex("^([aeiou]|xr|yt).*")

  fun translate(phrase: String): String =
    phrase.split(" ").joinToString(" ") { applyPigLatin(it) }

  private fun applyPigLatin(word: String): String {
    val start = when {
      word.matches(VOWEL_START_REGEX) -> 0
      word.take(3) in THREE_LETTER_CLUSTERS -> 3
      word.take(2) in TWO_LETTER_CLUSTERS -> 2
      else -> 1
    }
    return "${word.drop(start)}${word.take(start)}ay"
  }
}
