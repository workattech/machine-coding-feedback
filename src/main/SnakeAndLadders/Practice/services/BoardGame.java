package SnakeAndLadders.Practice.services;

import SnakeAndLadders.Practice.model.*;

public class BoardGame {
    private Board board;
    private int noOfPlayers=0;
    private int winningPosition = 100;
    private Printer printer;

    public BoardGame(Board board) {
        this.board = board;
        this.printer = new CMDPrinter();
    }

    public void startGame() {
        noOfPlayers=board.getPlayers().size();
        Dice dice = board.getDice();
        int playerTurnWithId = -1;
        int move;
        int nextPos;
        while(true) {
            playerTurnWithId=(playerTurnWithId+1)%noOfPlayers;
            Player player = board.getPlayerWithId(playerTurnWithId);
            move = dice.rollDice();
            nextPos = move(move + player.getPosition());
            printer.printNextMove(player,move,nextPos);
            player.setPosition(nextPos);
            if(nextPos == winningPosition) {
                printer.printWinMove(player);
                break;
            }
        }

    }
    protected int move(int position) {
        if(position>winningPosition) return 0;
        Snake snake = board.getSnakeWithPosition(position);
        Ladder ladder = board.getLadderWithPosition(position);
        if(snake!=null) {
            return snake.getEnd_pos();
        }
        if(ladder!=null) {
            return ladder.getEndPos();
        }
        return position;
    }
}
