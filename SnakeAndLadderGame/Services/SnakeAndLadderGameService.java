package Services;

import java.util.*;

import Models.*;

public class SnakeAndLadderGameService {
    final private static int DEFAULT_NUMBER_OF_DICE = 1;
    private boolean endGameAfterFirstWinner;
    private int noOfPlayers;
    private int remainingPlayers;
    private int currWinnerRank;
    private int noOfDices;
    private BoardService boardService;
    private Queue<Player> players;
    private DiceService diceService;

    public SnakeAndLadderGameService(int noOfPlayers, Board board, Queue<Player> players) {
        this.noOfPlayers = noOfPlayers;
        this.remainingPlayers = noOfPlayers;
        this.noOfDices = SnakeAndLadderGameService.DEFAULT_NUMBER_OF_DICE;
        this.players = players;
        this.currWinnerRank = 1;
        this.boardService = new BoardService(board);
        this.diceService = new DiceService();
    }

    public SnakeAndLadderGameService(int noOfPlayers, int noOfDices, Board board, Queue<Player> players) {
        this.noOfPlayers = noOfPlayers;
        this.remainingPlayers = noOfPlayers;
        this.noOfDices = noOfDices;
        this.currWinnerRank = 1;
        this.players = players;
        this.boardService = new BoardService(board);
        this.diceService = new DiceService();
    }

    public boolean getEndGameAfterFirstWinner() {
        return this.endGameAfterFirstWinner;
    }

    public void setEndGameAfterFirstWinner(boolean endGameAfterFirstWinner) {
        this.endGameAfterFirstWinner = endGameAfterFirstWinner;
    }

    public Queue<Player> startGame() {
        while(!this.isGameOver()) {
            Player playerWithTurn = this.getPlayerWithTurn();
            int initialPosition = playerWithTurn.getPosition();
            int sumOfAllDiceValues = this.rollDices();
            this.movePlayerBy(sumOfAllDiceValues, playerWithTurn);
            System.out.println(playerWithTurn.getName() + " rolled a " + sumOfAllDiceValues + " and moved from " + initialPosition + " to " + playerWithTurn.getPosition());
            this.updatePlayerStatus(playerWithTurn);
            if(playerWithTurn.getStatus() == PlayerStatus.WON) {
                System.out.println(playerWithTurn.getName() + " wins the game with rank " + playerWithTurn.getRank());
            }
        }
        markRemainingPlayersAsLost();
        return this.players;
    }

    private void markRemainingPlayersAsLost() {
        Queue<Player> tmpPlayers = new ArrayDeque<Player>();
        while(players.size() != 0) {
            Player currPlayer = players.peek();
            if(currPlayer.getStatus() == PlayerStatus.PLAYING) {
                currPlayer.setStatus(PlayerStatus.LOST);
            }
            players.remove();
            tmpPlayers.add(currPlayer);
        }
        players = tmpPlayers;
    }

    private void updatePlayerStatus(Player player) {
        if(player.getPosition() == boardService.getSize()) {
            player.setStatus(PlayerStatus.WON);
            player.setRank(this.currWinnerRank++);
            this.remainingPlayers--;
        }
    }

    private void movePlayerBy(int diceValue, Player player) {
        int newPosition = player.getPosition() + diceValue;
        if(!boardService.validPosition(newPosition)) {
            return;
        }
        while(boardService.isSnakeOrLadderAt(newPosition)) {
            newPosition = boardService.getNewPosition(newPosition);
        }
        player.setPosition(newPosition);
        return;
    }

    private Player getPlayerWithTurn() {
        Player playerWithTurn = players.poll();
        while(playerWithTurn.getStatus() != PlayerStatus.PLAYING) {
            players.add(playerWithTurn);
            playerWithTurn = players.poll();
        }
        players.add(playerWithTurn);
        return playerWithTurn;
    }

    private int rollDices() {
        int sumOfAllDiceValues = 0;
        int numberOfDicesRolled = 0;
        while(numberOfDicesRolled < noOfDices) {
            sumOfAllDiceValues += diceService.roll();
            numberOfDicesRolled++;
        }
        return sumOfAllDiceValues;
    }

    private boolean isGameOver() {
        if(this.remainingPlayers == 1 || (this.remainingPlayers < this.noOfPlayers && this.getEndGameAfterFirstWinner())) {
            return true;
        }
        return false;
    }
}