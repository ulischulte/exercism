import java.util.*
import kotlin.math.ceil
import kotlin.math.sqrt

private fun normalizeText(text: String) = text.lowercase(Locale.getDefault()).filter { it.isLetterOrDigit() }

private fun formSquareMatrix(text: String): List<String> {
  val numberOfColumns = ceil(sqrt(text.length.toDouble())).toInt().coerceAtLeast(1)
  return text.chunked(numberOfColumns).map { chunk -> chunk.padEnd(numberOfColumns, ' ') }
}

private fun transposeMatrix(matrix: List<String>): List<String> {
  val firstColIndices = matrix.firstOrNull()?.indices ?: emptyList()
  return firstColIndices.map { col -> matrix.map { row -> row[col] }.joinToString("") }
}

object CryptoSquare {
  fun ciphertext(plaintext: String): String {
    val normalizedText = normalizeText(plaintext)
    val squareMatrix = formSquareMatrix(normalizedText)
    val transposedMatrix = transposeMatrix(squareMatrix)
    return transposedMatrix.joinToString(" ")
  }
}
