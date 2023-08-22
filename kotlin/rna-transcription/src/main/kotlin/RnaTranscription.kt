fun transcribeToRna(dna: String): String {
  return dna.map { when (it) {
    'G' -> 'C'
    'C' -> 'G'
    'T' -> 'A'
    'A' -> 'U'
    else -> throw IllegalArgumentException("Invalid DNA sequence")
  } }.joinToString("")
}
