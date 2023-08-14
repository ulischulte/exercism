object Pangram {
  fun isPangram(input: String): Boolean =
    ('a'..'z').all { input.lowercase().contains(it) }
}
