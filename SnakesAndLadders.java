import java.util.*;

public class SnakesAndLadders {
    private List<Player> players;
    private int[] snakes, ladders;
    private final int lastPos=100;
    SnakesAndLadders(String[] players, int[][] snakes, int[][] ladders) {
        this.players=new ArrayList<>();
        for(String pl: players){
            Player player = new Player(pl);
            this.players.add(player);
        }
        this.snakes=new int[101];
        Arrays.fill(this.snakes, -1);
        for(int[] sn: snakes) {
            this.snakes[sn[0]] = sn[1];
        }

        this.ladders=new int[101];
        Arrays.fill(this.ladders, -1);
        for(int[] ld: ladders) {
            this.ladders[ld[0]] = ld[1];
        }
    }

    public void playGame() {

        while(true){
            for(Player p: players) {
                int diceRoll=new Random().nextInt(6)+1;
                int prevPos=p.getPosition();
                int newPos=movePlayer(p, diceRoll);
                System.out.println(p.getName()+" moved from "+prevPos + " to "+newPos);
                p.setPosition(newPos);
                if(newPos==lastPos) {
                    System.out.println("Player "+p.getName()+" has won the game");
                    return;
                }
            }
        }
    }

    private int movePlayer(Player player, int diceRoll) {
        int newPos=player.getPosition()+diceRoll;
        
        if(newPos>lastPos) return player.getPosition();

        while(snakes[newPos]!=-1 && ladders[newPos]!=-1){
            if(snakes[newPos] != -1) newPos=snakes[newPos];
            if(ladders[newPos] != -1) newPos=ladders[newPos];
        }

        return newPos;
    }
}
