object PigLatin {

  private val twoLetterClusters = setOf(
    "bl", "br", "ch", "cl", "cr", "dr", "fl", "fr", "gl", "gr", "pl", "pr",
    "qu", "rh", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th",
    "tr", "tw", "wh", "wr"
  )
  private val threeLetterClusters = setOf("spl", "spr", "str", "scr", "shr", "squ", "thr", "sch")

  fun translate(phrase: String) =
    phrase.split(" ").joinToString(" ") { applyPigLatin(it) }

  private fun applyPigLatin(word: String): String {
    val start = when {
      word.matches(Regex("^([aeiou]|xr|yt).*")) -> 0
      word.take(3) in threeLetterClusters -> 3
      word.take(2) in twoLetterClusters -> 2
      else -> 1
    }
    return "${word.drop(start)}${word.take(start)}ay"
  }
}
