class ChangeCalculator(private val coins: List<Int>) {

  private val sortedCoins: List<Int> = coins.sortedDescending()

  init {
    require(sortedCoins.all { it > 0 }) { "Coin values should be positive." }
  }

  fun computeMostEfficientChange(change: Int): List<Int> {
    require(change >= 0) { "Negative totals are not allowed." }

    if (change == 0) return listOf()

    return computeChange(sortedCoins, change)
      ?: throw IllegalArgumentException("The total $change cannot be represented in the given currency.")
  }

  private fun computeChange(sortedCoins: List<Int>, change: Int): List<Int>? {
    val sortedCoinsUsed = Array(change + 1) { Int.MAX_VALUE }
    sortedCoinsUsed[0] = 0

    val changeCombinations = Array(change + 1) { mutableListOf<Int>() }

    for (coin in sortedCoins) {
      for (changeAmount in coin..change) {
        if (sortedCoinsUsed[changeAmount - coin] != Int.MAX_VALUE && sortedCoinsUsed[changeAmount - coin] + 1 < sortedCoinsUsed[changeAmount]) {
          sortedCoinsUsed[changeAmount] = sortedCoinsUsed[changeAmount - coin] + 1
          changeCombinations[changeAmount] = (changeCombinations[changeAmount - coin] + coin).toMutableList()
        }
      }
    }

    return changeCombinations.last().takeIf { it.sum() == change }
  }
}
