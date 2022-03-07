package src.entities

import src.DEFAULT_BOARD_SIZE
import java.util.LinkedList

class Board(
    snakes: List<Snake> = LinkedList(),
    ladders: List<Ladder> = LinkedList(),
    private val size: Int = DEFAULT_BOARD_SIZE,
) {

    val dice = Dice()
    val snakeMap = hashMapOf<Int, Snake>()
    val ladderMap = hashMapOf<Int, Ladder>()

    init {
        validateBoard(snakes, ladders)

        snakes.forEach { snake ->
            snakeMap[snake.head] = snake
        }
        ladders.forEach { ladder ->
            ladderMap[ladder.start] = ladder
        }

        println("Board size $size")
    }

    private fun validateBoard(snakes: List<Snake>, ladders: List<Ladder>) {
        snakes.forEach { snake ->
            if (snake.head > size || snake.head < snake.tail)
                throw Exception("Invalid coordinates of Snake at ${snake.head} ${snake.tail}")
        }

        ladders.forEach { ladder ->
            if (ladder.end > size || ladder.end < ladder.start)
                throw Exception("Invalid coordinates of Ladder at ${ladder.start} ${ladder.end}")
        }
    }

    fun getSize(): Int {
        return size
    }
}
