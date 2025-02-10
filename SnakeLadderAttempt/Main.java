import Entity.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        int snakeCount = sc.nextInt();
        for(int i=1;i<=snakeCount;i++){
            int head = sc.nextInt();
            int tail = sc.nextInt();
            game.getGrid().addSnake(new Snake(head,tail));
        }

        int ladderCount = sc.nextInt();
        for(int i=1;i<=ladderCount;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            game.getGrid().addLadder(new Ladder(start,end));
        }

        int playerCount= sc.nextInt();
        for(int i=1;i<=playerCount;i++){
            String name = sc.next();
            game.getGrid().AddPlayer(new Player(0,name));
        }

        // Start the game
        game.Start();

    }
}