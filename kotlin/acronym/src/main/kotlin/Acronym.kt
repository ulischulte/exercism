object Acronym {
  fun generate(phrase: String): String = phrase
    .split(Regex("\\s|[-_]"))
    .mapNotNull { it.firstOrNull()?.uppercase() }
    .joinToString(separator = "")
}
