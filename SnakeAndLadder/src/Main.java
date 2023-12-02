import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int noOfSnakes = Integer.parseInt(args[0]);
        Map<Integer,Integer> snakes = new HashMap<>();
        int i = 1;
        for(;i<2*noOfSnakes; i+=2){
            snakes.put(Integer.parseInt(args[i]), Integer.parseInt((args[i+1])));
        }
        Map<Integer,Integer> ladders = new HashMap<>();
        int noOfLadders = Integer.parseInt(args[i]);
        i++;
        for(;i<2*noOfSnakes + 2*noOfLadders + 2;i+=2){
            ladders.put(Integer.parseInt(args[i]), Integer.parseInt(args[i+1]));
        }
        int noOfPlayers = Integer.parseInt(args[i]);
        i++;
        List<String> names = new ArrayList<>();
        for(;i<2*noOfSnakes + 2*noOfLadders + noOfPlayers+ 3;i++) {
            names.add(args[i]);
        }
        Game game = Game.getInstance();
        game.initializeGame(2,snakes,ladders, names);
        game.Play();
    }
}