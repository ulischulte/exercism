import java.util.*

object Isogram {

  fun isIsogram(input: String): Boolean {

    val seen = mutableSetOf<Char>()
    for (char in input.lowercase()) {
      if (!char.isLetter()) continue
      if (!seen.add(char)) {
        return false
      }
    }
    return true
  }
}
