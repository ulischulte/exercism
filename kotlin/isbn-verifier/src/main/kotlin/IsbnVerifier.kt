class IsbnVerifier {
    fun isValid(isbn: String): Boolean {
        val cleanIsbn = isbn.replace("-", "")
        if (cleanIsbn.length != 10 || !cleanIsbn.substring(0, 9).all(Char::isDigit)) {
            return false
        }

        return cleanIsbn.validateCheckCharacter() &&
            cleanIsbn.calculateIsbnCheckSum()
    }

    private fun String.validateCheckCharacter(): Boolean {
        return this.last().isDigit() || this.last() == 'X'
    }

    private fun String.calculateIsbnCheckSum(): Boolean {
        val sum = this.indices.sumOf { i ->
            val digit = if (this[i] == 'X') 10 else Character.getNumericValue(this[i])
            digit * (10 - i)
        }
        return sum % 11 == 0
    }
}
