package entities

class Player(val name : String) {

    private var position: Int = 0

    fun getPosition(): Int {
        return position
    }
    fun setPosition(newPosition : Int) {
        position = newPosition
    }
}