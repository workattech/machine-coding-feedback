import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final Board board;
    private final Map<Integer,Integer> snakeMap;
    private final Map<Integer,Integer> ladderMap;
    private final List<Player> winnerList;
    private boolean gameWon;

    public Game(Board board) {
        this.board = board;
        this.snakeMap = new HashMap<>();
        this.ladderMap = new HashMap<>();
        this.winnerList = new ArrayList<>();
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

    private void printMove(Player player, int diceNumber, int start, int end) {
        System.out.println(player.getPlayerName() + " rolled a " + diceNumber + " and moved from " +
                           start + " to " + end);
        return;
    }

    private int calculateDieSumUtil() {
        int maximumDieOutput = 6;
        int turn2 = (int) ((Math.random()*6) + 1);
        maximumDieOutput += turn2;
        if(turn2 == 6) {
            int turn3 = (int) ((Math.random()*6) + 1);
            if(turn3 == 6)
                return 0;
            maximumDieOutput += turn3;
        }
        return maximumDieOutput;
    }

    private int calculateDieSum(int numOfDie) {
        int sum = 0,i;
        for(i=0;i<numOfDie;i++) {
            int val = (int) ((Math.random()*6) + 1);
            if(val == 6)
                val = calculateDieSumUtil();
            sum += val;
        }
        return sum;
    }

    private int getPieceCoordinate(Tile tile, Player player, int newCoordinate) {
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

    private boolean checkPlayerHasWon(Player player, int tileNumber) {
        if(tileNumber == 100) {
            this.gameWon = true;
            System.out.println(player.getPlayerName() + " wins the game");
            return true;
        }
        return false;
    }

    public void playGame() {
        List<Player> playersList = this.board.getPlayerList();
        for(Player player: playersList) {
            if(winnerList.size() == (playersList.size() - 1))
                return;
            if(player.getHasWon())
                continue;
            int diceNumber = calculateDieSum(1);
            Tile playerPieceTile = null;
            if(player.getPlayerCoordinate()!=0)
                playerPieceTile = this.board.getGameBoard().get(player.getPlayerCoordinate());
            if((diceNumber+player.getPlayerCoordinate())>Constants.MAXIMUM_TILES) {
                printMove(player, diceNumber, player.getPlayerCoordinate(), player.getPlayerCoordinate());
                continue;
            }
            if(playerPieceTile != null)
                playerPieceTile.getPlayerSet().remove(player);
            int updatedPlayerCoordinate = player.getPlayerCoordinate()+diceNumber;
            playerPieceTile = this.board.getGameBoard().get(updatedPlayerCoordinate);
            updatedPlayerCoordinate = getPieceCoordinate(playerPieceTile, player, updatedPlayerCoordinate);
            printMove(player, diceNumber, player.getPlayerCoordinate(), updatedPlayerCoordinate);
            player.setPlayerCoordinate(updatedPlayerCoordinate);
            playerPieceTile.getPlayerSet().add(player);
            if(checkPlayerHasWon(player,updatedPlayerCoordinate)) {
                player.setHasWon();
                winnerList.add(player);
            }
        }
        return;
    }
}
