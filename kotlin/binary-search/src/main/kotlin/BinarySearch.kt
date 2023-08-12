object BinarySearch {
  fun search(list: List<Int>, item: Int, first: Int = 0, last: Int = list.size - 1): Int {
    if (first > last) throw NoSuchElementException()

    val index = first + (last - first) / 2

    return when {
      list[index] == item -> index
      list[index] < item -> search(list, item, index + 1, last)
      else -> search(list, item, first, index - 1)
    }
  }
}
