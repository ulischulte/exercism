class Triangle<out T : Number>(a: T, b: T, c: T) {
    private val sides = listOf(a, b, c)
        .map(Number::toDouble)
        .sorted()

    init {
        require(sides[0] > 0 && sides[0] + sides[1] > sides[2]) {
            "not a triangle"
        }
    }

    val isEquilateral: Boolean get() = sides[0] == sides[1] && sides[1] == sides[2]
    val isIsosceles: Boolean get() = sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]
    val isScalene: Boolean get() = !isIsosceles
}
