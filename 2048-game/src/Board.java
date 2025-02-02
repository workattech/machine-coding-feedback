// import java.util.ArrayList;
// import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int size;
    int basevalue;
    int numberOfValues;
    Tile[][] tiles;
    int[] boardValues;

    Board(int size,int base,int count){
        this.size = size;
        this.basevalue = base;
        this.numberOfValues = count;
        initializeValues(base,count);
        initializeBoard(size);
    }

    private void initializeValues(int base,int numberOfValues){
        boardValues = new int[numberOfValues];
        for(int i=0;i<numberOfValues;i++){
            boardValues[i] = (int) Math.pow((double)base, (double)(i+1));
        }
    }
    private void initializeBoard(int size){
        tiles = new Tile[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j < size;j++){
                tiles[i][j] = new Tile();
                tiles[i][j].value = 0;
            }
        }

        for(int i=0;i<2;i++){
            int row = ThreadLocalRandom.current().nextInt(0,size);
            int column = ThreadLocalRandom.current().nextInt(0,size);

            if(tiles[row][column].value == 2){
                i--;
            }
            else tiles[row][column].value = 2;
        }
    }

    // public void insertTile(){
    //     int row = ThreadLocalRandom.current().nextInt(0,size);
    //     int column = ThreadLocalRandom.current().nextInt(0,size);
    //     int number = ThreadLocalRandom.current().nextInt(0,6);

    //     tiles[row][column].value = tileValueList.get(number);
    // }
}
