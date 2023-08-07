class Squares(n: Int) {

    private val range = 1..n

    fun squareOfSum(): Int = range.sum().calculateSquare()

    fun sumOfSquares(): Int = range.sumOf { it.calculateSquare() }

    fun difference(): Int = squareOfSum().minus(sumOfSquares())

    private fun Int.calculateSquare(): Int = this * this
}
