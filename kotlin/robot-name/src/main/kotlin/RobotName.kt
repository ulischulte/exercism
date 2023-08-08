import kotlin.random.Random

class Robot {

  var name: String = UniqueRobotNameGenerator.generateUniqueRobotName()

  fun reset() {
    name = UniqueRobotNameGenerator.generateUniqueRobotName()
  }
}

object UniqueRobotNameGenerator {

  private val generatedRobotNames = mutableSetOf<String>()

  fun generateUniqueRobotName(): String {
    var newRobotName: String
    do {
      val letterPart = ('A'..'Z').random().toString() + ('A'..'Z').random().toString()
      val digitPart = Random.nextInt(100, 999).toString()
      newRobotName = "$letterPart$digitPart"
    } while (newRobotName in generatedRobotNames)
    generatedRobotNames.add(newRobotName)
    return newRobotName
  }
}
