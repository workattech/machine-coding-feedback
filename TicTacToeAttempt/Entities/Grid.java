package Entities;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int rowSize;
    private int colSize;
    List<Player> players;
    Peice  peice;
    private char [][] board;

    public Grid(int rowSize,int colSize){
        players = new ArrayList<>();
        this.colSize=colSize;
        this.rowSize=rowSize;
        this.board = new char[rowSize][colSize];
    }

    public List<Player> getPlayers() {
        return players;
    }

    public char getboard(int i, int j){
        return board[i][j];
    }
    public void setboard(int i,int j){
        board[i][j]='-';
    }

    public void changeBoard(int i,int j,Player p){
        board[i][j]=p.getPeice();
    }


    public void addPlayer(Player player){
        players.add(player);
    }
}
