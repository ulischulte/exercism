data class MatrixCoordinate(val rowIndex: Int, val columnIndex: Int)

class Matrix(private val grid: List<List<Int>>) {

	val saddlePoints: Set<MatrixCoordinate> by lazy {
		grid.mapIndexed { rowIndex, row ->
			row.mapIndexedNotNull { columnIndex, _ ->
				val maxInRow = row.maxOrNull()
				val minInColumn = grid.minOfOrNull { it[columnIndex] }
				if (maxInRow == minInColumn)
					MatrixCoordinate(rowIndex + 1, columnIndex + 1)
				else null
			}
		}.flatten().toSet()
	}
}
