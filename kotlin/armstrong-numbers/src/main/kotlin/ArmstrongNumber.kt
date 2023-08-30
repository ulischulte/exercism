import kotlin.math.pow

object ArmstrongNumber {

  fun check(input: Int): Boolean {
    require(input >= 0) { "Input must be a non-negative integer." }
    val digits = input.toString().map(Character::getNumericValue)
    val power = digits.size
    val sum = digits.sumOf { it.toDouble().pow(power) }
    return sum.toInt() == input
  }

}
