object WordCount {
  fun phrase(phrase: String): Map<String, Int> {
    return phrase.lowercase()
        .split(Regex("[^a-zA-Z0-9']+"))
        .filter(String::isNotEmpty)
        .map { it.trim('\'') }
        .groupBy { it }
        .mapValues { it.value.size }
  }
}
