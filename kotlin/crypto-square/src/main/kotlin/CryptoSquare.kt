import java.util.*
import kotlin.math.ceil
import kotlin.math.sqrt

private fun String.normalize() = lowercase(Locale.getDefault()).filter(Char::isLetterOrDigit)

private fun String.formSquareMatrix(): List<String> {
    val numColumns = ceil(sqrt(length.toDouble())).toInt().coerceAtLeast(1)
    return chunked(numColumns).map { it.padEnd(numColumns, ' ') }
}

private fun List<String>.transposeMatrix(): List<String> {
    val firstColIndices = firstOrNull()?.indices ?: emptyList()
    return firstColIndices.map { col -> map { row -> row[col] }.joinToString("") }
}

object CryptoSquare {
    fun ciphertext(plaintext: String) = plaintext
        .normalize()
        .formSquareMatrix()
        .transposeMatrix()
        .joinToString(" ")
}
