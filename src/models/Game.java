package models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Player player;
    private GameStatus status;
    private List<GameTurn> gameTurns;

    public GameStatus getStatus() {
        return status;
    }

    public Board getBoard() {
        return board;
    }

    public Game(Player player, long size) {
        this.player = player;
        this.board = new Board(size);
        this.status = GameStatus.ACTIVE;
        this.gameTurns = new ArrayList<>();
    }

    public void makeGameTurn(String gameTurnInput) {
        GameTurn gameTurn = new GameTurn(gameTurnInput);
        gameTurns.add(gameTurn);
        board.makeMove(gameTurn);
        if(board.isBoardFull()) {
            status = GameStatus.LOST;
        }
        else if(board.hasMaxNumber()) {
            status = GameStatus.WON;
        }
    }
}
