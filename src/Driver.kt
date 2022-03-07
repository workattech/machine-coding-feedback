package src

import src.entities.*
import java.util.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    val snakes = LinkedList<Snake>()
    val ladders = LinkedList<Ladder>()
    val players = LinkedList<Player>()
    val boardSize: Int?

    try {
        println("Enter board size")
        boardSize = readLine()?.toInt()

//        println("Enter number of Snakes")
        var noOfSnakes: Int = readLine()?.toInt()!!

        while (noOfSnakes-- > 0) {
            val snakeParams = readLine()?.split(" ".toRegex())!!
            snakes.add(Snake(snakeParams[0].toInt(), snakeParams[1].toInt()))
        }

//        println("Enter number of Ladders")
        var noOfLadders: Int = readLine()?.toInt()!!
        while (noOfLadders-- > 0) {
            val ladderParams = readLine()?.split(" ".toRegex())!!
            ladders.add(Ladder(ladderParams[0].toInt(), ladderParams[1].toInt()))
        }

//        println("Enter number of players")
        var noOfPlayers: Int = readLine()?.toInt()!!

        while (noOfPlayers-- > 0) {
            val name = readLine()!!
            players.add(Player(name))
        }

        val board: Board =
            if (boardSize != null) {
                Board(snakes, ladders, boardSize)
            } else {
                Board(snakes, ladders)
            }

        val game = Game(board, players)
        game.play()

    } catch (e: NumberFormatException) {
        println("Invalid Input Entered. Try Again!!")
        exitProcess(0)
    } catch (e: java.lang.Exception) {
        println(e.message)
        exitProcess(0)
    }
}
