package entities

import java.util.Queue

class Game(private val board: Board,
           private val players : Queue<Player>) {

    fun play() {

        val dice = board.getDice()
        while (players.size > 1) {
            val currPlayer = players.poll()
            val numberRolled = dice.rollDice()

            val currPosition = currPlayer.getPosition()
            val newPosition = board.calculateNewPosition(currPosition, numberRolled)

            println(currPlayer.name + " rolled a " + numberRolled + " and moved from " + currPosition + " to " + newPosition)

            if (newPosition == BOARD_SIZE){
                println(currPlayer.name + " wins the game")
            }
            else{
                currPlayer.setPosition(newPosition)
                players.offer(currPlayer)
            }
        }
    }

}