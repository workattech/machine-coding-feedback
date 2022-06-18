import java.io.*;
import java.util.HashMap;

public class Ladder {

    private HashMap<Integer,Integer> ladders;

    public Ladder(int numLadders, BufferedReader bufferedReader)throws IOException{
        ladders = new HashMap<>();

        for(int i = 0 ; i < numLadders ; i++){

            String inp[] = bufferedReader.readLine().trim().split(" ");

            this.ladders.put(Integer.parseInt(inp[0].trim()),Integer.parseInt(inp[1].trim()));
        }
    }

    boolean containsLadder(int position){

        if(ladders.containsKey(position))
            return true;

        return false;

    }

    int getLadder(int position){

        return ladders.get(position);

    }
}