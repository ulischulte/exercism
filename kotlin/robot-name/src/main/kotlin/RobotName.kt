class Robot(private val nameGenerator: UniqueRobotNameGenerator = UniqueRobotNameGenerator) {
  var name: String = nameGenerator.generateUniqueRobotName()

  fun reset() {
    name = nameGenerator.generateUniqueRobotName()
  }
}

object UniqueRobotNameGenerator {

  private val generatedRobotNames = mutableSetOf<String>()

  private fun generateRandomRobotName() = buildString {
    repeat(2) { append(('A'..'Z').random()) }
    append((100..999).random())
  }

  fun generateUniqueRobotName(): String {
    var newRobotName: String
    do {
      newRobotName = generateRandomRobotName()
    } while (newRobotName in generatedRobotNames)

    generatedRobotNames.add(newRobotName)
    return newRobotName
  }
}
