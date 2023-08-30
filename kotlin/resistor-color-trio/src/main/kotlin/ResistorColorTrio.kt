import kotlin.math.pow

object ResistorColorTrio {

  private fun value(colorValue: List<Int>): Int {
    return colorValue.take(2)
      .reduceIndexed { index, color, acc -> (color * 10.0.pow(index).toInt()) + acc }
  }

  fun text(vararg input: Color): String {
    require(input.size >= 2)
    val colorOrdinals = input.map(Color::ordinal)
    val baseValue = value(colorOrdinals) * 10.0.pow(colorOrdinals.last()).toInt()
    return with(baseValue) {
      when {
        this >= 1_000_000 -> "${this / 1_000_000} megaohms"
        this >= 1_000 -> "${this / 1_000} kiloohms"
        else -> "$this ohms"
      }
    }
  }
}

