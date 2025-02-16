package models;

import Dto.GameDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    Board board;
    List<Player> players;

    public Game(GameDTO gameDTO){
        players = gameDTO.getPlayers();
        board = new Board(gameDTO.getObstacles());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


}
