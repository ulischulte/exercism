class CustomSet(vararg elements: Int) {

  private val items = elements.toMutableSet()

  fun isEmpty() = items.isEmpty()

  fun isSubset(other: CustomSet) = items.all { it in other.items }

  fun isDisjoint(other: CustomSet) = items.none { it in other.items }

  fun contains(element: Int) = items.contains(element)

  fun intersection(other: CustomSet): CustomSet = apply { items.retainAll(other.items) }

  fun add(element: Int) = items.add(element)

  operator fun plus(other: CustomSet) = apply { items.addAll(other.items) }

  operator fun minus(other: CustomSet) = apply { items.removeAll(other.items) }

  override fun hashCode() = items.hashCode()

  override fun equals(other: Any?) = other is CustomSet && items == other.items
}
