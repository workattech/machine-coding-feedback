package src.entities

import java.util.Queue

class Game(private val board: Board,
           private val players : Queue<Player>) {

    fun play() {

        val dice = board.dice
        while (players.size > 1) {
            val currPlayer = players.poll()
            val numberRolled = dice.rollDice()

            val currPosition = currPlayer.getPosition()
            val newPosition = calculateNewPosition(currPosition, numberRolled)

            println(currPlayer.name + " rolled a " + numberRolled + " and moved from " + currPosition + " to " + newPosition)

            if (newPosition == board.getSize()){
                println(currPlayer.name + " wins the game")
            }
            else{
                currPlayer.setPosition(newPosition)
                players.offer(currPlayer)
            }
        }
    }

    private fun calculateNewPosition(currPosition: Int, numberRolled: Int): Int {
        val newPos = currPosition + numberRolled
        if (newPos > board.getSize())
            return currPosition

        //Check if there's a snake at newPos
        board.snakeMap[newPos]?.let {
            return it.tail
        }

        //Check if there's a ladder at newPos
        board.ladderMap[newPos]?.let {
            return it.end
        }

        return newPos
    }
}
