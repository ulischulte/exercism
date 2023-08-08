object Flattener {
  fun flatten(input: Collection<Any?>): List<Any> =
      input.flatMap {
        when (it) {
          is Collection<*> -> flatten(it)
          null -> emptyList()
          else -> listOf(it)
        }
      }
}
