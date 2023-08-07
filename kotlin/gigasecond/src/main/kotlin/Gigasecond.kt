import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(private val startTime: LocalDateTime) {

    constructor(startDate: LocalDate) : this(startDate.atStartOfDay())

    val date: LocalDateTime get() = startTime.plusSeconds(1_000_000_000L)
}
