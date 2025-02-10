package Entity;
import java.util.HashMap;
import java.util.List;

public class Game {
    private boolean isGameOver;
    Grid grid;
    Dice dice;
    public Game(){
        this.grid = new Grid();
        this.isGameOver=false;
    }
    public Grid getGrid() {
        return grid;
    }


    public void Start(){
        int i=0;
        List<Player> playerList = grid.getPlayers();
        HashMap<Integer,Integer> snakeMap = new HashMap<>();
        HashMap<Integer,Integer>ladderMap = new HashMap<>();

        // Adding Snake and ladders in the hashmap
        for(Snake snake : grid.snakes) {
            snakeMap.put(snake.getHead(),snake.getTail());
        }
        for(Ladder ladder : grid.ladders){
            ladderMap.put(ladder.getStart(),ladder.getEnd());
        }

        while(!isGameOver) {
            for(Player p :playerList) {
                int throwDice = dice.rollDice();
                String Name = p.getName();
                int initialPostion = p.getPosition();

                int laterPosition = initialPostion + throwDice;

                // Case if it goes Above 100
                if (laterPosition > 100) {
                    laterPosition = initialPostion;
                }

                // Either of snake or ladder can be there
                if (snakeMap.containsKey(laterPosition)) {
                    laterPosition = snakeMap.get(laterPosition);
                } else if (ladderMap.containsKey(laterPosition)) {
                    laterPosition = ladderMap.get(laterPosition);
                }

                //setting the new position
                p.setPosition(laterPosition);

                System.out.println(Name + " rolled a " + throwDice + " and moved from " + initialPostion + " to " + laterPosition);

                if (p.getPosition() == 100) {
                    System.out.println(Name + " Wins");
                    isGameOver = true;
                    break;
                }
            }
        }
    }

}
