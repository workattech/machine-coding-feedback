package Dto;

import lombok.Getter;
import lombok.Setter;
import models.Obstacles;
import models.Player;

import java.util.List;

public class GameDTO {
    List<Player> players;
    List<Obstacles> obstacles;

    public GameDTO(List<Player> players, List<Obstacles> obstacles) {
        this.players = players;
        this.obstacles = obstacles;
    }

    public List<Obstacles> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacles> obstacles) {
        this.obstacles = obstacles;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
