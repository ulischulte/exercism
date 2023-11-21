import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

class Meetup(private val month: Int, private val year: Int) {
  private val daysOfWeekForYearMonth: Map<DayOfWeek, List<LocalDate>> by lazy {
    YearMonth.of(year, month).let { yearMonth ->
      (1..yearMonth.lengthOfMonth())
        .map(yearMonth::atDay)
        .groupBy(LocalDate::getDayOfWeek)
    }
  }

  fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {
    return daysOfWeekForYearMonth[dayOfWeek]
      ?.let { daysOfWeek ->
        when (schedule) {
          MeetupSchedule.FIRST -> daysOfWeek.first()
          MeetupSchedule.SECOND -> daysOfWeek.getOrNull(1)
          MeetupSchedule.THIRD -> daysOfWeek.getOrNull(2)
          MeetupSchedule.FOURTH -> daysOfWeek.getOrNull(3)
          MeetupSchedule.LAST -> daysOfWeek.last()
          MeetupSchedule.TEENTH -> daysOfWeek.find { it.dayOfMonth in 13..19 }
        }
      } ?: throw IllegalArgumentException("Invalid schedule or day of week.")
  }
}
