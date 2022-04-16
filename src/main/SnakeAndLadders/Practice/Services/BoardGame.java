package SnakeAndLadders.Practice.Services;

import SnakeAndLadders.Practice.Model.Board;
import SnakeAndLadders.Practice.Model.Dice;
import SnakeAndLadders.Practice.Model.Players;

public class BoardGame {
    Board board;
    private int noOfPlayers=0;
    private int winningPosition = 100;
    private Printer print;

    public BoardGame(Board board) {
        this.board = board;
        this.print = new CMDPrinter();
    }

    public void startGame() {
        noOfPlayers=board.getPlayers().size();
        Dice dice = board.getDice();
        int playerTurn = -1;
        int move;
        int nextPos;
        while(true) {
            playerTurn=(playerTurn+1)%noOfPlayers;
            Players player = board.getPlayers().get(playerTurn);
            move = dice.rollDice();
            nextPos = move(move + player.getPosition());
            print.printNextMove(player,move,nextPos);
            player.setPosition(nextPos);
            if(nextPos == winningPosition) {
                print.printWinMove(player);
                break;
            }
        }

    }
    public int move(int position) {
        if(position>winningPosition) return 0;
        if(board.getSnakes().containsKey(position)) {
            return board.getSnakes().get(position).getEnd_pos();
        }
        if(board.getLadders().containsKey(position)) {
            return board.getLadders().get(position).getEnd_pos();
        }
        return position;
    }
}
