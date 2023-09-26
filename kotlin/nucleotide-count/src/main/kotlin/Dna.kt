class Dna(private val sequence: String) {
  init {
    require(sequence.validSequence())
  }

  val nucleotideCounts: Map<Char, Int>
    get() {
      val nucleotideCounts: MutableMap<Char, Int> =
        "ACGT".associate { it to 0 }.toMutableMap()
      val sequenceList = sequence.toList()

      sequenceList.groupingBy { it }.eachCount().forEach { (nucleotide, count) ->
        nucleotideCounts[nucleotide] = nucleotideCounts.getOrDefault(nucleotide, 0) + count
      }

      return nucleotideCounts
    }

  private fun String.validSequence(): Boolean = matches(Regex("[ACGT]*"))

}
