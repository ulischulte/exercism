class DiamondPrinter {
  private val alphabet = 'A'..'Z'

  fun printToList(input: Char): List<String> {
    require(input in 'A'..'Z')
    val size = alphabet.indexOf(input) + 1
    val upHalf = (0 until size).map { createDiamondLine(it, size) }
    val downHalf = upHalf.dropLast(1).reversed()
    return upHalf + downHalf
  }

  private fun createDiamondLine(index: Int, size: Int): String = with(alphabet.elementAt(index)) {
    if (index == 0)
      "${pad(size - 1)}$this${pad(size - 1)}"
    else
      "${pad(size - index - 1)}$this${pad(index * 2 - 1)}$this${pad(size - index - 1)}"
  }

  private fun pad(size: Int): String = " ".repeat(size)
}
