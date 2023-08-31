object Transpose {

  fun transpose(matrix: List<String>): List<String> {
    val maxLength = matrix.maxOfOrNull { it.length } ?: 0
    return (0 until maxLength).map { index ->
      val column = matrix.map { it.getOrNull(index) }
      val withoutTrailingNulls = column.dropLastWhile { it == null }
      val result = StringBuilder()
      withoutTrailingNulls.forEach { result.append(it ?: ' ') }
      result.toString()
    }
  }

}

