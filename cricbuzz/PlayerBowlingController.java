package cricbuzz;

import java.util.*;

public class PlayerBowlingController {
   Deque<Player> bowler;
    Map<Player,Integer> blowerOverCount;
    Player currentBowler;
    public PlayerBowlingController(List<Player> bowlers) {
        setBowlersList(bowlers);
    }

    private void setBowlersList(List<Player> bowlersList) {
        this.bowler = new LinkedList<>();
        blowerOverCount = new HashMap<>();
        for (Player bowler : bowlersList) {
            this.bowler.addLast(bowler);
            blowerOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {

        Player Player = bowler.poll();
        if(blowerOverCount.get(Player)+1 == maxOverCountPerBowler) {
            currentBowler = Player;
        }
        else {
            currentBowler = Player;
            bowler.addLast(Player);
            blowerOverCount.put(Player, blowerOverCount.get(Player)+1);
        }
    }

    public Player getCurrentBowler(){
        return currentBowler;
    }
}
