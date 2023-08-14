class ChangeCalculator(private val coins: List<Int>) {

  init {
    require(coins.all { it > 0 }) { "Coin values should be positive." }
  }

  fun computeMostEfficientChange(change: Int): List<Int> {
    require(change >= 0) { "Negative totals are not allowed." }

    if (change == 0) return listOf()

    val sortedCoins = coins.sortedDescending()
    return computeChange(sortedCoins, change)
      ?: throw IllegalArgumentException("The total $change cannot be represented in the given currency.")
  }

  private fun computeChange(sortedCoins: List<Int>, change: Int): List<Int>? {
    val coinsUsed = Array(change + 1) { Int.MAX_VALUE }
    coinsUsed[0] = 0

    val changeCombinations = Array(change + 1) { mutableListOf<Int>() }

    for (coin in sortedCoins) {
      for (i in coin..change) {
        if (coinsUsed[i - coin] != Int.MAX_VALUE && coinsUsed[i - coin] + 1 < coinsUsed[i]) {
          coinsUsed[i] = coinsUsed[i - coin] + 1
          changeCombinations[i] = (changeCombinations[i - coin] + coin).toMutableList()
        }
      }
    }

    return changeCombinations.last().takeIf { it.sum() == change }
  }
}
