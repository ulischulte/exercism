object ResistorColor {

  private enum class Color(val resistanceValue: Int) {
    BLACK(0),
    BROWN(1),
    RED(2),
    ORANGE(3),
    YELLOW(4),
    GREEN(5),
    BLUE(6),
    VIOLET(7),
    GREY(8),
    WHITE(9);

    companion object {
      fun fromString(colorName: String): Color? {
        return values().firstOrNull { it.name.equals(colorName, ignoreCase = true) }
      }
    }
  }

  fun colorCode(input: String): Int {
    val color = Color.fromString(input) ?: throw IllegalArgumentException("Invalid color name: $input")
    return color.resistanceValue
  }

  fun colors(): List<String> {
    return Color.values().map { it.name.lowercase() }
  }
}
