package entities

import kotlin.random.Random

class Dice {

    private val random = Random(System.currentTimeMillis())

    fun rollDice(): Int {
        return 1 + random.nextInt(DICE_MAX_VALUE)
    }
}
