class Triangle<out T : Number>(private val a: T, private val b: T, private val c: T) {
    init {
        val sides = listOf(a, b, c)
            .map(Number::toDouble)
            .sorted()

        require(sides[0] > 0 && sides[0] + sides[1] > sides[2]) {
            "not a triangle"
        }
    }

    val isEquilateral: Boolean get() = a == b && b == c
    val isIsosceles: Boolean get() = a == b || b == c || a == c
    val isScalene: Boolean get() = !isIsosceles
}
