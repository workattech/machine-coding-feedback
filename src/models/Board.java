package models;

import java.util.List;

public class Board {
    final int maxPosition;
    List<Obstacles> obstacles;

    public Board(List<Obstacles> obstacles) {
        this.maxPosition = 100;
        this.obstacles = obstacles;
    }

    public Board(int maxPosition, List<Obstacles> obstacles) {
        this.maxPosition = maxPosition;
        this.obstacles = obstacles;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public List<Obstacles> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacles> obstacles) {
        this.obstacles = obstacles;
    }
}
