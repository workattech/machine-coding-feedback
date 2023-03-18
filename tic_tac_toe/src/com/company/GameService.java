package com.company;

import java.util.ArrayList;

public class GameService {
    private InputService inputService;
    private char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};

    public GameService(InputService inputService) {
        this.inputService = inputService;
    }

    private void checkWinner(char c) {
        boolean winnerFound = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((i == j) || (i + j == (board.length - 1))) {
                    if (checkDiagonal(i, j, c) || checkSides(i, j, c)) {
                        winnerFound = true;
                    }
                } else {
                    if (checkSides(i, j, c))
                        winnerFound = true;
                }
            }
        }
        if (winnerFound) {
            if (c == 'X') {
                System.out.println(this.inputService.getPlayers().get(0) + " won the game.");
            } else {
                System.out.println(this.inputService.getPlayers().get(1) + " won the game.");
            }
        }
    }

    private boolean checkSides(int i, int j, char c) {
        for (int k = 0; k < board.length; k++) {
            if ((board[k][j] != c) || (board[i][k] != c)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int i, int j, char c) {
        if (i == j) {
            for (int k = 0; k < board.length; k++) {
                if (board[k][k] != c)
                    return false;
            }
        } else {
            for (int k = 0; k < board.length; k++) {
                if (board[k][board.length - k - 1] != c)
                    return false;
            }
        }
        return true;
    }

    public void playGame() {
        boolean lastMoveIsInvalidWithX = false;
        boolean lastMoveIsInvalidWithO = false;
        ArrayList<String> moves = this.inputService.getMoves();
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).equals("exit")) {
                System.out.println("exit encountered.... not taking inputs now");
                break;
            } else {
                if (!lastMoveIsInvalidWithO) {
                    String[] cellPositionX = moves.get(i).split(" ");
                    if (board[Integer.parseInt(cellPositionX[0]) - 1][Integer.parseInt(cellPositionX[1]) - 1] == '-') {
                        board[Integer.parseInt(cellPositionX[0]) - 1][Integer.parseInt(cellPositionX[1]) - 1] = 'X';
                        showBoard();
                        checkWinner('X');
                        lastMoveIsInvalidWithX = false;
                    } else {
                        System.out.println("Invalid move.... cell already filled\n");
                        lastMoveIsInvalidWithX = true;
                        i--;
                    }
                }

                if (moves.get(++i).equals("exit")) {
                    System.out.println("exit encountered.... not taking inputs now\n");
                    break;
                } else {
                    if (!lastMoveIsInvalidWithX) {
                        String[] cellPositionO = moves.get(i).split(" ");
                        if (board[Integer.parseInt(cellPositionO[0]) - 1][Integer.parseInt(cellPositionO[1]) - 1] == '-') {
                            board[Integer.parseInt(cellPositionO[0]) - 1][Integer.parseInt(cellPositionO[1]) - 1] = 'O';
                            showBoard();
                            checkWinner('O');
                            lastMoveIsInvalidWithO = false;
                        } else {
                            System.out.println("Invalid move.... cell already filled");
                            lastMoveIsInvalidWithO = true;
                            i--;
//                        break;
                        }
                    }
                }
            }
        }

        boolean isGameOver = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == '-')
                    isGameOver = false;
            }
        }

        if(isGameOver)
            System.out.println("Game Over");
    }

    public void showBoard() {
        for (char[] charArray : board) {
            for (char c : charArray) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
