import logic.SnLGame;

import java.util.*;

public class Driver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        Map<Integer, Integer> snakesMap = new HashMap<>();
        for (int i = 0; i < s; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            snakesMap.put(from, to);
        }
        int l = sc.nextInt();
        Map<Integer, Integer> laddersMap = new HashMap<>();
        for (int i = 0; i < l; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            laddersMap.put(from, to);
        }
        int p = sc.nextInt();
        List<String> players = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String playerName = sc.next();
            players.add(playerName);
        }
        SnLGame game = new SnLGame(snakesMap, laddersMap, players);
    }

}
