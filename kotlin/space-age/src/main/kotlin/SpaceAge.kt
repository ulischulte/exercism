class SpaceAge(private val seconds: Long) {

  fun onEarth() = getAgeOnPlanet(Planet.EARTH)
  fun onMercury() = getAgeOnPlanet(Planet.MERCURY)
  fun onVenus() = getAgeOnPlanet(Planet.VENUS)
  fun onMars() = getAgeOnPlanet(Planet.MARS)
  fun onJupiter() = getAgeOnPlanet(Planet.JUPITER)
  fun onSaturn() = getAgeOnPlanet(Planet.SATURN)
  fun onUranus() = getAgeOnPlanet(Planet.URANUS)
  fun onNeptune() = getAgeOnPlanet(Planet.NEPTUNE)

  private fun getAgeOnPlanet(planet: Planet): Double = (this.seconds.toDouble() / 31557600.0 / planet.relativeYear)

  companion object {
    enum class Planet(val relativeYear: Double) {
      EARTH(1.0),
      MERCURY(0.2408467),
      VENUS(0.61519726),
      MARS(1.8808158),
      JUPITER(11.862615),
      SATURN(29.447498),
      URANUS(84.016846),
      NEPTUNE(164.79132);
    }
  }
}
