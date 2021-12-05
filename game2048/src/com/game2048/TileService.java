package com.game2048;

import com.game2048.models.Game2048Tile;

import java.util.Random;

public class TileService {
    private int randomTileNumber;
    Game2048Tile tile;

    public TileService() {
        this.randomTileNumber = randomTileNumberGenerator();
        tile = new Game2048Tile(randomTileNumber);
    }

    public int randomNumberGenerator() {
        int minRange = 1; // power(2,1) = 2
        int maxRange = 11; // power(2,11) = 2048
        Random random = new Random();
        int randomTile = minRange + random.nextInt(maxRange - minRange + 1);
        return randomTile;
    }

    public int powerOfTwo(int index) {
        int powerOfTwo = 1;
        for (int i = 1; i <= index; i++) { //2,4,8,16,32,64,128,256,512,1024,2048
            powerOfTwo *= 2;
        }
        return powerOfTwo;
    }

    public int randomTileNumberGenerator() {
        int randomValue = randomNumberGenerator();
        int randomTileNumber = powerOfTwo(randomValue);
        return randomTileNumber;
    }
}
