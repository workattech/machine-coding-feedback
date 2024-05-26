package in.aghorii.snakeandladder.model;

import java.util.List;

public class Board {

    private final int boardSize;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private List<Player> players;

    private Board(BoardBuilder builder) {
        this.snakes = builder.snakes;
        this.ladders = builder.ladders;
        this.players = builder.players;
        this.boardSize = builder.boardSize;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public static class BoardBuilder {

        private int boardSize;
        private List<Snake> snakes;
        private List<Ladder> ladders;
        private List<Player> players;

        public BoardBuilder() {}

        public BoardBuilder boardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public BoardBuilder snakes(List<Snake> snakes) {
            this.snakes = snakes;
            return this;
        }

        public BoardBuilder ladders(List<Ladder> ladders) {
            this.ladders = ladders;
            return this;
        }

        public BoardBuilder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }
}
