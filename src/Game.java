import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    static int currentPlayer = 0;
    static boolean gameOver = false;
    static int numPlayers;
    static Snake snakes;
    static Ladder ladders;
    static List<Player> players;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numSnakes = Integer.parseInt(bufferedReader.readLine());
        snakes = new Snake(numSnakes, bufferedReader);

        int numLadders = Integer.parseInt(bufferedReader.readLine());
        ladders = new Ladder(numLadders,bufferedReader);

        numPlayers = Integer.parseInt(bufferedReader.readLine());
        players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {

            Player player = new Player(bufferedReader.readLine().trim());
            players.add(player);

        }

        startGame();

    }

    static void startGame(){


        while (!gameOver){

            Player p = players.get(currentPlayer);
            currentPlayer  = getNextPlayer();

            int diceValue = rollDice();

            if(diceValue + p.getCurrentPosition() > 100){
                System.out.print(p.getPlayerName() + " rolled a " + diceValue + " and moved from " + p.getCurrentPosition() + " to " + p.getCurrentPosition()+"\n");
                continue;
            }

            System.out.print(p.getPlayerName() + " rolled a " + diceValue + " and moved from " + p.getCurrentPosition());

            if(ladders.containsLadder(diceValue + p.getCurrentPosition() )){
                p.setCurrentPosition(ladders.getLadder(diceValue + p.getCurrentPosition()));
                System.out.println(" to " + p.getCurrentPosition());
            }
            else if(snakes.containsSnake(diceValue + p.getCurrentPosition() )){
                p.setCurrentPosition(snakes.getSnake(diceValue + p.getCurrentPosition()));
                System.out.println(" to " + p.getCurrentPosition());
            }
            else {
                p.setCurrentPosition(diceValue + p.getCurrentPosition());
                System.out.println(" to " + p.getCurrentPosition());
            }

            if(p.getCurrentPosition() == 100){
                System.out.println(p.getPlayerName() + " wins the game");
                gameOver = true;
            }
        }

    }

    static int rollDice(){

        return (int)(Math.random()*6+1);

    }

    static int getNextPlayer(){

        currentPlayer++;

        if(currentPlayer == numPlayers)
            currentPlayer = 0;

        return currentPlayer;
    }

}
