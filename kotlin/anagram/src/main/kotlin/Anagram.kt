class Anagram(private val anagram: String) {
  private val charCounts = anagram.lowercase().charsCount()

  fun match(anagrams: Collection<String>): Set<String> {
    return anagrams.filter {
      it.isAnagram(this.anagram.lowercase())
    }.toSet()
  }

  private fun String.isAnagram(anagram: String): Boolean {
    return this.length == anagram.length &&
        this.lowercase() != anagram &&
        this.lowercase().charsCount() == charCounts
  }

  private fun String.charsCount() : Map<Char, Int>{
    return this.groupingBy { it }.eachCount()
  }
}
