package entities

class Ladder(
     val start : Int,
     val end : Int,){

    init {
        //Sample validation check
        if (start >= BOARD_SIZE || end > BOARD_SIZE )
            throw java.lang.Exception("Incorrect Ladder Parameters")
    }
}