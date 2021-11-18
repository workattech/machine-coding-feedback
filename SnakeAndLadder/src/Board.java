import java.util.List;

public class Board {

    // The values below can be modified to meet the optional requirement 1
    // MAX = 12, MIN = 2
    final int MAX_DICE_VALUE = 6;
    final int MIN_DICE_VALUE = 1;
    /**
     * This is for the SIX_REPEAT, Optional requirement 4
     * Could not complete this because of time constraints
     * Approach:
     *  => If the flag is enabled, simply roll the die 3 times and not the value
     *  => And then update, if 6, invalidate the turn.
     *
     */
    final boolean SIX_REPEAT = false;

    // This can be given as input, and hence the optional requirement 2 is fulfilled.
    private int sizeofBoard;
    private int cellsOnBoard;
    private List<Ladder> ladders;
    private List<Snake> snakes;
    private List<Player> players;

    public Board(int sizeofBoard, List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
        this.sizeofBoard = sizeofBoard;
        this.cellsOnBoard = sizeofBoard*sizeofBoard;
        this.ladders = ladders;
        this.snakes = snakes;
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    // Assumption: There is only one snake/Ladder at a particular point.
    public Response checkSnakeAtLocation(int location){

        for(Snake snake: snakes){
            Response snakeResp = snake.checkLadderAtLocation(location);
            if(snakeResp.isStatus()){
                return snakeResp;
            }
        }

        return new Response(false,-1);

    }

    public Response checkLadderAtLocation(int location){

        for(Ladder ladder: ladders){
            Response ladderResp = ladder.checkLadderAtLocation(location);
            if(ladderResp.isStatus()){
                return ladderResp;
            }
        }

        return new Response(false,-1);
    }

    public Response checkIfWon(){

        for(Player player: players){
            if(player.getCurrentPosition() == this.cellsOnBoard){
                return new Response(true,player);
            }
        }
        return new Response(false,null);
    }

    public boolean updatePlayerOnBoard(Player player){
        int random_int = (int)Math.floor(Math.random()*(MAX_DICE_VALUE-MIN_DICE_VALUE+1)+MIN_DICE_VALUE);
        int newPosition = player.getCurrentPosition() + random_int;

        if(newPosition > this.cellsOnBoard){
            System.out.println("can't move as destination is more than possible");
            return false;
        }

        if(checkSnakeAtLocation(newPosition).isStatus()){
            newPosition = (Integer) checkSnakeAtLocation(newPosition).getResponse();
        }

        if(checkLadderAtLocation(newPosition).isStatus()){
            newPosition = (Integer) checkLadderAtLocation(newPosition).getResponse();
        }

        System.out.println(player.getName() + " rolled a "+random_int + " and moved from "+ player.getCurrentPosition() + " to " + newPosition);
        player.updateLocation(newPosition);
        return true;
    }

    public int getSizeofBoard() {
        return sizeofBoard;
    }

    public void setSizeofBoard(int sizeofBoard) {
        this.sizeofBoard = sizeofBoard;
    }

    public int getCellsOnBoard() {
        return cellsOnBoard;
    }

    public void setCellsOnBoard(int cellsOnBoard) {
        this.cellsOnBoard = cellsOnBoard;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }
}
