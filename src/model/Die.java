package model;

import java.util.Random;

public class Die {

    int numberOfFaces;

    public Die() {
        this.numberOfFaces = 6;
    }

    public Die(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int rollDie() {
        Random rand = new Random();
        int rolledValue = rand.nextInt((numberOfFaces - 1) + 1) + 1;
        return rolledValue;
    }

}
