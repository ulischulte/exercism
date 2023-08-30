object BeerSong {

  fun verses(startBottles: Int, takeDown: Int): String {
    val range = when {
      startBottles >= takeDown -> startBottles downTo takeDown
      else -> startBottles..takeDown
    }
    return range.joinToString(separator = "\n") { number -> verse(number).capitalizeFirstCharacter() }
  }

  private fun verse(number: Int): String {

    val bottlesOnTheWall = when (number) {
      0 -> "no more bottles"
      1 -> "1 bottle"
      else -> "$number bottles"
    }

    val takeOneDown = when (number) {
      0 -> "Go to the store and buy some more, 99 bottles"
      1 -> "Take it down and pass it around, no more bottles"
      2 -> "Take one down and pass it around, 1 bottle"
      else -> "Take one down and pass it around, ${number - 1} bottles"
    }

    return "$bottlesOnTheWall of beer on the wall, $bottlesOnTheWall of beer.\n$takeOneDown of beer on the wall.\n"
  }

  private fun String.capitalizeFirstCharacter(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
  }
}
