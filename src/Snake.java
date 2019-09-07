import java.io.*;
import java.util.HashMap;

public class Snake {

    private HashMap<Integer,Integer> snakes;

    public Snake(int numSnakes, BufferedReader bufferedReader)throws IOException{
        snakes = new HashMap<>();

        for(int i = 0 ; i < numSnakes ; i++){

            String inp[] = bufferedReader.readLine().trim().split(" ");

            this.snakes.put(Integer.parseInt(inp[0].trim()),Integer.parseInt(inp[1].trim()));
        }
    }

    boolean containsSnake(int position){

        if(snakes.containsKey(position))
            return true;

        return false;

    }

    int getSnake(int position){

        return snakes.get(position);

    }
}