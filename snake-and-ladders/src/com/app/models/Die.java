package com.app.models;

import java.util.Random;

class Die {
    private int currentFace;
    private int numberOfFaces;
    private int numberOfDies;

    int getCurrentFace() {
        return currentFace;
    }


    Die(int currentFace, int numberOfFaces, int numberOfDies) {
        this.currentFace = currentFace;
        this.numberOfFaces = numberOfFaces;
        this.numberOfDies = numberOfDies;
    }

    void roll() {
        Random r = new Random();
        this.currentFace = r.nextInt(this.numberOfFaces*this.numberOfDies) + numberOfDies;
    }
}
