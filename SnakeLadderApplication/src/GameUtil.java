import java.util.*;

public class GameUtil {
    private static Integer destination;
    private static Map<Player,List<Integer>> playerMoves;

    public static void start(List<Player> players, int dices,Dice dice, Board board) {
        Deque<Player> playerTurns = new LinkedList<>();
        playerMoves = new HashMap<>();
        for(Player player: players) {
            playerTurns.addLast(player);
            playerMoves.put(player, new ArrayList<>());
            playerMoves.get(player).add(0);
        }
        destination = board.getRows() * board.getColumns();
        boolean isWinner = false;
        while (!isWinner) {
            Player player = playerTurns.removeFirst();
            int diceNumber = dice.roll(dices);
            Move move = getMove(player,diceNumber,board);
            playerMoves.get(player).add(move.getFinalPos());
            System.out.println(player.getPlayerName() + " rolled a " + diceNumber + " and move from " + move.getInitialPos() + " to " + move.getFinalPos() );
            if(move.getFinalPos() == destination ) {
                System.out.println(player.getPlayerName() + " wins the game");
                isWinner = true;
            }
            else {
                playerTurns.addLast(player);
            }
        }
    }

    private static Move getMove(Player player,int diceNumber,Board board) {
        List<Integer> moves = playerMoves.get(player);
        int currentPos = moves.get(moves.size()-1);
        int newPos = currentPos + diceNumber;
        if(newPos > destination)
            return new Move(currentPos,currentPos);
        if(board.getLaddersMap().containsKey(newPos))
            return new Move(currentPos,board.getLaddersMap().get(newPos));
        if(board.getSnakeMap().containsKey(newPos))
            return new Move(currentPos,board.getSnakeMap().get(newPos));
        return new Move(currentPos,newPos);
    }
}