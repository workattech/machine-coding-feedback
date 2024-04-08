package model;

import java.util.Arrays;

public class Grid {
    private int numberOfRows;
    private int numberOfColumns;
    private int numberOfPlayers;
    private char[][] grid;
    private Player[] players;
    private int currentPlayer;

    public Grid(int numberOfRows, int numberOfColumns, Player[] players) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.grid = new char[numberOfRows][numberOfColumns];
        this.players = players;
        this.numberOfPlayers = players.length;
        this.currentPlayer = 0;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
