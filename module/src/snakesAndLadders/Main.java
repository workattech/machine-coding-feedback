package snakesAndLadders;

import snakesAndLadders.game.Game;
import snakesAndLadders.model.Player;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number of snakes: ");
        int snakeCount = sc.nextInt();
        Map<Integer, Integer> snakes = new HashMap<>();
        for(int i = 0; i < snakeCount; i++){
            System.out.println("Enter snake head and tail: ");
            int head = sc.nextInt();
            int tail = sc.nextInt();
            snakes.put(head, tail);
        }
        System.out.println("Please enter number of ladders: ");
        int ladderCount = sc.nextInt();
        Map<Integer, Integer> ladders = new HashMap<>();
        for(int i = 0; i < ladderCount; i++){
            System.out.println("Enter ladder base and top: ");
            int base = sc.nextInt();
            int top = sc.nextInt();
            ladders.put(base, top);
        }
        System.out.println("Please enter number of players: ");
        int playerCount = sc.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < playerCount; i++){
            System.out.println("Enter player name: ");
            String name = sc.next();
            players.add(new Player(name));
        }
        Game game = new Game(players, snakes, ladders);
        game.start();
    }
}