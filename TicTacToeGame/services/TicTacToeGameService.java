package services;

import models.*;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToeGameService {
    private static final String USER_WANTS_TO_EXIT_GAME = "Exit Game";
    int noOfPlayers;
    Queue<Player> players;
    BoardService boardService;

    public TicTacToeGameService(List<Player> players, Board board) {
        this.noOfPlayers = players.size();
        this.players = new ArrayDeque<Player>();
        for(Player player: players) {
            this.players.add(player);
        }
        this.boardService = new BoardService(board);
    }

    public void startGame() {
        this.boardService.printBoard();
        Player playerWithTurn;
        do {
            playerWithTurn = getPlayerWithTurn();
            int move[] = new int[2];
            try {
                move = getValidMoveFromUser(playerWithTurn.getName());
            } catch(Exception e) {
                if(e.getMessage().equals(TicTacToeGameService.USER_WANTS_TO_EXIT_GAME)) {
                    break;
                }
            }
            this.playMove(playerWithTurn, move);
            this.boardService.printBoard();
        } while(!isGameOver());
        printGameResult(playerWithTurn);
    }

    private Player getPlayerWithTurn() {
        Player playerWithTurn = players.poll();
        players.add(playerWithTurn);
        return playerWithTurn;
    }

    private int[] getValidMoveFromUser(String playerName) throws Exception {
        int move[] = new int[2];
        String message = playerName + " please play your move";
        do {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            String row, col;
            row = sc.next();
            if(row.equalsIgnoreCase("exit")) {
                throw new Exception(TicTacToeGameService.USER_WANTS_TO_EXIT_GAME);
            }
            col = sc.next();
            move[0] = Integer.parseInt(row);
            move[1] = Integer.parseInt(col);
            message = playerName + " please enter a valid move";
        } while(!this.boardService.isValidMove(move[0], move[1]));
        return move;
    }

    private void printGameResult(Player playerWithLastTurn) {
        if(this.hasAnyPlayerWon()) {
            System.out.println(playerWithLastTurn.getName() + " won the game");
        } else if(this.isGameDraw()) {
            System.out.println("--------Draw---------");
        } else {
            System.out.println(playerWithLastTurn.getName() + " exited the game");
        }
    }

    private void playMove(Player playerWithTurn, int[] move) {
        this.boardService.playMove(move[0], move[1], playerWithTurn.getSymbol());
    }

    private boolean isGameOver() {
        if(this.hasAnyPlayerWon() || this.isGameDraw()) {
            return true;
        }
        return false;
    }

    private boolean hasAnyPlayerWon() { // Check row, col, main diagonal, cross-diagonal
        return this.isAllSamePiecesInAnyRow() ||
               this.isAllSamePiecesInAnyCol() ||
               this.isAllSamePiecesInMainDiagonal() ||
               this.isAllSamePiecesInCrossDiagonal();
    }

    private boolean isAllSamePiecesInCrossDiagonal() {
        int boardSize = this.boardService.getBoard().getSize();
        char piece = this.boardService.getBoard().getPieceAt(1, boardSize);
        if (piece == '-') return false;
        for(int idx = 2; idx <= boardSize; idx++) {
            if(this.boardService.getBoard().getPieceAt(idx, boardSize - idx + 1) != piece) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllSamePiecesInMainDiagonal() {
        int boardSize = this.boardService.getBoard().getSize();
        char piece = this.boardService.getBoard().getPieceAt(1, 1);
        if(piece == '-') return false;
        for(int idx = 2; idx <= boardSize; idx++) {
            if(this.boardService.getBoard().getPieceAt(idx, idx) != piece) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllSamePiecesInAnyCol() {
        int boardSize = this.boardService.getBoard().getSize();
        for(int col = 1; col <= boardSize; col++) {
            boolean allSamePieces = true;
            char piece = this.boardService.getBoard().getPieceAt(1, col);
            if(piece == '-') continue;
            for(int row = 2; row <= boardSize; row++) {
                if(this.boardService.getBoard().getPieceAt(row, col) != piece) {
                    allSamePieces = false;
                }
            }
            if (allSamePieces) return true;
        }
        return false;
    }

    private boolean isAllSamePiecesInAnyRow() {
        int boardSize = this.boardService.getBoard().getSize();
        for(int row = 1; row <= boardSize; row++) {
            boolean allSamePieces = true;
            char piece = this.boardService.getBoard().getPieceAt(row, 1);
            if(piece == '-') continue;
            for(int col = 2; col <= boardSize; col++) {
                if(this.boardService.getBoard().getPieceAt(row, col) != piece) {
                    allSamePieces = false;
                }
            }
            if(allSamePieces) return true;
        }
        return false;
    }

    private boolean isGameDraw() {
        boolean gameDraw = true;
        int boardSize = this.boardService.getBoard().getSize();
        for (int row = 1; row <= boardSize; row++) {
            for (int col = 1; col <= boardSize; col++) {
                if (this.boardService.getBoard().getPieceAt(row, col) == '-') {
                    gameDraw = false;
                }
            }
        }
        return gameDraw;
    }
}
