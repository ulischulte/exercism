class Series(private val series: String) {

  init {
    require(series.all(Char::isDigit))
  }

  fun getLargestProduct(span: Int): Long {
    require(span <= series.length)
    return series.windowed(span)
      .map { inputNumbers -> inputNumbers.map { character -> character.toString().toLong() } }
      .map { numbers -> numbers.reduce { product, digit -> product * digit } }
      .maxOf { it }
  }

}
