import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dice count:");
        int diceCount = Integer.parseInt(scanner.nextLine().trim());

        if(diceCount < 1 || diceCount > 3){
            System.out.println("Invalid dice count. Must be between 1 and 3.");
            return;
        }

        Dice dice = new Dice(diceCount);


        // Read Board
        System.out.println("Enter board dimension N (you will get an NxN board):");
        int dimension = Integer.parseInt(scanner.nextLine().trim());
        int boardSize = dimension * dimension;

        if(dimension < 3 || dimension > 15){
            System.out.println("Invalid dimension. Must be between 3 and 15.");
            return;
        }
        System.out.println("Your board size is: " +  boardSize);


        // Read Snakes
        System.out.println("Enter the number of snakes:");
        int snakeCount = Integer.parseInt(scanner.nextLine().trim());
        List<Snake> snakeList = new ArrayList<>();
        for(int i=0; i<snakeCount; i++){
            System.out.println("Enter the head and tail in the format (eg. H T) for snake " + (i+1));
            String parts[] = scanner.nextLine().trim().split(" ");
            int head = Integer.parseInt(parts[0]);
            int tail = Integer.parseInt(parts[1]);

            if(head <= tail || head > boardSize || tail >= boardSize || head == boardSize){
                System.out.println("Invalid snake: head must be > tail and within board size");
                return;
            }

            snakeList.add(new Snake(head, tail));
        }

        // Read ladders
        System.out.println("Enter the number of ladders:");
        int ladderCount = Integer.parseInt(scanner.nextLine().trim());
        List<Ladder> ladderList = new ArrayList<>();
        for(int i=0; i<ladderCount; i++){
            System.out.println("Enter the start and end in the format (eg. S E) for snake " + (i+1));
            String[] parts = scanner.nextLine().trim().split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);

            if (start >= end || start <= 0 || end > boardSize) {
                System.out.println("Invalid ladder: start must be < end and within board size");
                return;
            }

            ladderList.add(new Ladder(start, end));
        }

        // Read players
        System.out.println("Enter the number of players:");
        int playerCount = Integer.parseInt(scanner.nextLine().trim());
        List<Player> playerList = new ArrayList<>();
        for(int i=0; i<playerCount; i++){
            System.out.println("Enter the name for player " + (i+1));
            String name = scanner.nextLine().trim();
            playerList.add(new Player(name));
        }

        // Initialize board
        Board board = new Board(snakeList, ladderList, boardSize);

        // Play game
        boolean gameWon = false;
        int currentPlayerIndex = 0;

        while(!gameWon){
            Player currentPlayer = playerList.get(currentPlayerIndex);

            int currentPosition = currentPlayer.getPosition();
            int diceRoll = dice.rollDice();
            int nextPosition = currentPosition + diceRoll;

            if(nextPosition > board.getBoardSize()){
                nextPosition = currentPosition;
            } else {
                nextPosition = board.getNextPosition(nextPosition);
            }

            currentPlayer.setPosition(nextPosition);

            System.out.printf("%s rolled %d and moved from %d to %d%n",
                    currentPlayer.getName(), diceRoll, currentPosition, nextPosition);

            if(nextPosition == 100){
                System.out.println(currentPlayer.getName() + " wins the game");
                gameWon = true;
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size();
        }
        scanner.close();
    }
}
