package entities

import java.util.LinkedList

class Board(private val size : Int = 100,
            private val snakes : List<Snake> = LinkedList(),
            private val ladders : List<Ladder> = LinkedList()) {

    fun getSize(): Int {
        return size
    }
    fun getDice(): Dice {
        return Dice()
    }

    fun calculateNewPosition(currPosition: Int, numberRolled: Int): Int {

        val newPos = currPosition + numberRolled
        if(newPos > BOARD_SIZE)
            return currPosition

        snakes.forEach {snake ->
           if(snake.head == newPos)
               return snake.tail
        }

        ladders.forEach { ladder ->
            if (ladder.start == newPos)
                return ladder.end
        }

        return newPos
    }
}