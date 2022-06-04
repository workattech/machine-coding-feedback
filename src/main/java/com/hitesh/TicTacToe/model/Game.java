package com.hitesh.TicTacToe.model;

import lombok.Getter;

import java.util.*;

@Getter
public class Game {

    private String id;
    private Board board;
    private boolean isWin;
    private Player currentPlayer;
    private GameState gameState;
    private List<Player> playerList;

    public Game(String id, List<Player> playerList, Player currentPlayer) {
        this.id = id;
        this.playerList = playerList;
        this.currentPlayer = currentPlayer;
        this.isWin = false;
        this.board = new Board(UUID.randomUUID().toString(), new ArrayList<>());
        this.gameState = new GameState();
    }

    public boolean isNotOver(){

        boolean winCheck =  gameState.checkForWin(board);

        if(winCheck){
            this.isWin = true;
            return false;
        }

        List<List<Cell>> cellList = board.getCellList();

        return cellList.stream()
                .flatMap(Collection::stream)
                .anyMatch(cell -> !board.isCellOccupied(cell));

    }

    public void processMove(int x, int y) {

        changeCurrentPlayer();

        Cell cell = new Cell(x,y,null);

        boolean isMoveValid = Move.move(board, gameState, cell,
                new Piece(getCurrentPlayer().getPieceTaken().getValue()));

        if(!isMoveValid){
            System.out.println("Invalid Move");
            return;
        }

        List<Player> playerList = getPlayerList();

        Player player = playerList.get(0);
        playerList.remove(0);
        playerList.add(player);

        board.print();

    }

    public void changeCurrentPlayer() {
        this.currentPlayer = playerList.get(0);
    }
}
