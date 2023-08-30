import kotlin.math.pow

object ResistorColorTrio {

  private fun value(colorValue: List<Int>): Int =
    colorValue.take(2).reduceIndexed { _, acc, color -> acc * 10 + color }

  fun text(vararg input: Color): String {
    require(input.size >= 2)
    val colorOrdinals = input.map(Color::ordinal)
    val baseValue = value(colorOrdinals) * 10.0.pow(colorOrdinals.last()).toInt()

    return formatOutput(baseValue)
  }

  private fun formatOutput(baseValue: Int): String =
    when {
      baseValue >= 1_000_000 -> "${baseValue / 1_000_000} megaohms"
      baseValue >= 1_000 -> "${baseValue / 1_000} kiloohms"
      else -> "$baseValue ohms"
    }
}
