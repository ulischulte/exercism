data class Year(private val year: Int) {
  val isLeap: Boolean = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)
}
