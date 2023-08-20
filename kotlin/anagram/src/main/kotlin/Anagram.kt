class Anagram(private val anagram: String) {

  fun match(anagrams: Collection<String>): Set<String> {
    return anagrams.filter {
      it.isAnagram(this.anagram.lowercase())
    }
      .toSet()
  }

  private fun String.isAnagram(anagram: String): Boolean {
    val anagramChars = anagram.lowercase().toMutableList()
    this.lowercase().toList().forEach { anagramChar: Char ->
      anagramChars.remove(anagramChar)
    }
    return anagramChars.isEmpty() && this.length == anagram.length && this.lowercase() != anagram
  }
}
