package Entity;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    List<Player>players;
    List<Snake>snakes;
    List<Ladder>ladders;

    public Grid(){
        this.players = new ArrayList<>();
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addLadder(Ladder l){
        ladders.add(l);
    }

    public void addSnake(Snake s){
        snakes.add(s);
    }

    public void AddPlayer(Player p){
        players.add(p);
    }


}
