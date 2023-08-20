class Anagram(private val word: String) {

  private val normalizedWord = word.lowercase()
  private val wordCharCounts = normalizedWord.charsCount()

  fun match(anagrams: Collection<String>): Set<String> =
    anagrams.filter { it.isAnagram(normalizedWord, wordCharCounts) }.toSet()
}

fun String.isAnagram(word: String, wordCharCounts: Map<Char, Int>): Boolean {
  val lowerCased = this.lowercase()
  return length == word.length &&
      lowerCased != word &&
      lowerCased.charsCount() == wordCharCounts
}

fun String.charsCount(): Map<Char, Int> =
  this.groupingBy { it }.eachCount()
