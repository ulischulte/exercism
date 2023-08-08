data class MatrixCoordinate(val rowIndex: Int, val columnIndex: Int)

class Matrix(private val grid: List<List<Int>>) {

	val saddlePoints: Set<MatrixCoordinate> get() = calculateSaddlePoints()

	private fun calculateSaddlePoints(): Set<MatrixCoordinate> {
		val saddlePoints = mutableSetOf<MatrixCoordinate>()
		grid.forEachIndexed { rowIndex, row ->
			row.forEachIndexed { columnIndex, _ ->
				val maxInRow = row.maxOrNull()
				val minInColumn = grid.minOfOrNull { it[columnIndex] }
				if (maxInRow == minInColumn) {
					saddlePoints.add(MatrixCoordinate(rowIndex + 1, columnIndex + 1))
				}
			}
		}
		return saddlePoints.toSet()
	}
}
