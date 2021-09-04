package snakeandladder.model;

public class Dice {
    public int getDiceRoll(){
        return (int)(Math.random()*(7-1)+1);//used to get random number in range[1,6]
    }
}
