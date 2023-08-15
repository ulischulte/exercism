object Raindrops {
  fun convert(input: Int): String = buildString {
    if (input % 3 == 0) append("Pling")
    if (input % 5 == 0) append("Plang")
    if (input % 7 == 0) append("Plong")
    if (isEmpty()) append(input)
  }
}
