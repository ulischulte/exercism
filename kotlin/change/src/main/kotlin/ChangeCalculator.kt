class ChangeCalculator(private val coins: List<Int>) {

  fun computeMostEfficientChange(change: Int): List<Int> {
    require(change >= 0) { "Negative totals are not allowed." }
    if (change <= 0) return listOf()
    return computeChange(change).sorted()
  }

  private fun computeChange(change: Int): List<Int> {
    val changes = MutableList(change + 1) { emptyList<Int>() }
    for (i in 0..change) {
      val minChange = computeMinChange(i, changes)
      changes[i] = if (minChange.sum() == i) minChange else emptyList()
    }
    return changes[change].takeIf { it.sum() == change }
      ?: throw IllegalArgumentException("The total $change cannot be represented in the given currency.")
  }

  private fun computeMinChange(change: Int, lowerChanges: List<List<Int>>): List<Int> {
    return coins.filter { it <= change }
      .reversed()
      .map { listOf(it) + lowerChanges[change - it] }
      .filter { it.sum() == change }
      .minByOrNull { it.size } ?: emptyList()
  }
}
