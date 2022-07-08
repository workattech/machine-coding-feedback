package com.app.models;

import java.util.Random;

public class Die {
    private int currentFace;
    private int numberOfFaces;
    private int numberOfDies;

    public int getCurrentFace() {
        return currentFace;
    }

    public int getNumberOfFaces() {
        return numberOfFaces;
    }

    public Die(int currentFace, int numberOfFaces, int numberOfDies) {
        this.currentFace = currentFace;
        this.numberOfFaces = numberOfFaces;
        this.numberOfDies = numberOfDies;
    }

    void roll() {
        Random r = new Random();
        int face =  r.nextInt(this.numberOfFaces*this.numberOfDies) + numberOfDies;
        int iterations=1;
        while (face%6==0 && iterations<3)
        {
            face +=  r.nextInt(this.numberOfFaces*this.numberOfDies) + numberOfDies;
            iterations++;
        }
        this.currentFace = face;
    }
}
