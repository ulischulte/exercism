object PigLatin {
  private val startingConsonantsPattern = Regex("^([bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]{1,3}.*)")
  private val twoLetterClusters = setOf(
    "bl", "br", "ch", "cl", "cr", "dr", "fl", "fr", "gl", "gr", "pl", "pr",
    "qu", "rh", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th",
    "tr", "tw", "wh", "wr"
  )
  private val threeLetterClusters = setOf("spl", "spr", "str", "scr", "shr", "squ", "thr", "sch")

  fun translate(phrase: String): String = phrase.split(" ").joinToString(" ") { word ->
    when {
      word.matches(Regex("^([aeiou]|xr|yt).*")) -> "${word}ay"
      word.matches(Regex("^[aeiouAEIOU](qu).*")) -> applyPigLatin(word, word.indexOf("qu") + 4)
      word.startsWithConsecutiveConsonants() -> when {
        threeLetterClusters.contains(word.take(3)) -> applyPigLatin(word, 3)
        twoLetterClusters.contains(word.take(2)) -> applyPigLatin(word, 2)
        else -> applyPigLatin(word, 1)
      }

      word.matches(Regex("^.*?[aeiou].*")) -> applyPigLatin(word, word.indexOfFirst { it.isVowel() })
      else -> applyPigLatin(word, word.indexOfFirst { it == 'y' }.let { if (it == 0) 1 else it })
    }
  }

  private fun applyPigLatin(word: String, splitIndex: Int): String =
    "${word.substring(splitIndex)}${word.substring(0, splitIndex)}ay"

  private fun Char.isVowel(): Boolean = this in "aeiou"

  private fun String.startsWithConsecutiveConsonants(): Boolean = this.matches(startingConsonantsPattern)
}
