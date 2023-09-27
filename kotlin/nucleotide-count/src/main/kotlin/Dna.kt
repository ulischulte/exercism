class Dna(private val sequence: String) {
  private val VALID_DNA = "ACGT"

  init {
    require(sequence.all { it in VALID_DNA })
  }

  val nucleotideCounts: Map<Char, Int>
    get() {
      val nucleotideCounts: MutableMap<Char, Int> =
        VALID_DNA.associate { it to 0 }.toMutableMap()
      val sequenceList = sequence.toList()

      sequenceList.groupingBy { it }.eachCount().forEach { (nucleotide, count) ->
        nucleotideCounts[nucleotide] = nucleotideCounts.getOrDefault(nucleotide, 0) + count
      }

      return nucleotideCounts
    }
}
