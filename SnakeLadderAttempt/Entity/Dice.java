package Entity;

import java.util.Random;

public class Dice {
    private int numberOfDices;

    Dice(int numberOfDices){
        this.numberOfDices=numberOfDices;
    }

    // Roll Dice
    public static int rollDice(){
        Random rand = new Random();
        int k = rand.nextInt(6)+1;
        return k;
    }
}
