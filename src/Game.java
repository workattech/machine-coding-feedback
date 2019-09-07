import java.util.HashMap;
import java.util.Map;

public class Game {
    private final Board board;
    private final Map<Integer,Integer> snakeMap;
    private final Map<Integer,Integer> ladderMap;
    private boolean gameWon;

    public Game(Board board) {
        this.board = board;
        this.snakeMap = new HashMap<>();
        this.ladderMap = new HashMap<>();
        this.gameWon = false;
    }

    public Board getBoard() {
        return this.board;
    }

    public boolean getGameWon() {
        return this.gameWon;
    }

    public void setGameWon() {
        this.gameWon = true;
    }

    public void addSnakeToBoard(int startCoordinate, int endCoordinate) {
        this.snakeMap.put(startCoordinate, endCoordinate);
    }

    public void addLadderToBoard(int startCoordinate, int endCoordinate) {
        this.ladderMap.put(startCoordinate, endCoordinate);
    }

    /*public boolean isGameWon() {
        for(Player player : this.board.getPlayerList()) {
            if(player.getHasWon())
                return true;
        }
        return false;
    }*/

    private void printMove(Player player, int diceNumber, int start, int end) {
        System.out.println(player.getPlayerName() + " rolled a " + diceNumber + " and moved from " +
                           start + " to " + end);
        return;
    }

    private int updateDieNumber() {
        int val1 = 6;
        int val2 = (int) ((Math.random()*6) + 1);
        val1 += val2;
        if(val2 == 6) {
            int val3 = (int) ((Math.random()*6) + 1);
            if(val3 == 6)
                return 0;
            val1 += val3;
        }
        return val1;
    }

    private int getDieNumber(int numOfDie) {
        int sum = 0,i;
        for(i=0;i<numOfDie;i++) {
            int val = (int) ((Math.random()*6) + 1);
            if(val == 6)
                val = updateDieNumber();
            sum += val;
        }
        return sum;
    }

    private int updateCoordinateBySnakesAndLadders(Tile tile, Player player, int newCoordinate) {
        while(tile.getHasSnake() || tile.getHasLadder()) {
            if(tile.getPlayerSet().contains(player))
                tile.getPlayerSet().remove(player);
            if (tile.getHasSnake()) {
                newCoordinate = this.snakeMap.get(newCoordinate);
            } else if (tile.getHasLadder()) {
                newCoordinate = this.ladderMap.get(newCoordinate);
            }
            tile = this.board.getGameBoard().get(newCoordinate);
        }
        return newCoordinate;
    }

    public void playGame() {
        for(Player player:this.board.getPlayerList()) {
            int diceNumber = getDieNumber(1);
            Tile tile = null;
            if(player.getPlayerCoordinate()!=0)
                tile = this.board.getGameBoard().get(player.getPlayerCoordinate());
            if((diceNumber+player.getPlayerCoordinate())>Constants.MAXIMUM_TILES) {
                printMove(player, diceNumber, player.getPlayerCoordinate(), player.getPlayerCoordinate());
                continue;
            }
            if(tile != null)
                tile.getPlayerSet().remove(player);
            int newCoordinate = player.getPlayerCoordinate()+diceNumber;
            tile = this.board.getGameBoard().get(newCoordinate);
            newCoordinate = updateCoordinateBySnakesAndLadders(tile, player, newCoordinate);
            printMove(player, diceNumber, player.getPlayerCoordinate(), newCoordinate);
            player.setPlayerCoordinate(newCoordinate);
            tile.getPlayerSet().add(player);
            if(newCoordinate == 100) {
                player.setHasWon();
                this.gameWon = true;
                System.out.println(player.getPlayerName() + " wins the game");
                return;
            }
        }
        return;
    }
}
