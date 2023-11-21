import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(private val seconds: Long) {

  private val earthYears = this.seconds / 31557600.0

  fun onEarth() = getAgeOnPlanet(1.0)

  fun onMercury() = getAgeOnPlanet(0.2408467)

  fun onVenus() = getAgeOnPlanet(0.61519726)

  fun onMars() = getAgeOnPlanet(1.8808158)

  fun onJupiter() = getAgeOnPlanet(11.862615)

  fun onSaturn() = getAgeOnPlanet(29.447498)

  fun onUranus() = getAgeOnPlanet(84.016846)

  fun onNeptune() = getAgeOnPlanet(164.79132)

  private fun getAgeOnPlanet(planetYears: Double): Double {
    val age = earthYears / planetYears
    return BigDecimal(age).setScale(2, RoundingMode.HALF_UP).toDouble()
  }
}
