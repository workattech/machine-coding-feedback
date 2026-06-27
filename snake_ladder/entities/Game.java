package snake_ladder.entities;

import snake_ladder.behaviours.DiceRollBehaviour;

import java.util.List;
import java.util.Map;

public class Game {

    private final int gameSize;
    private final Map<Integer, GameElement> elementsMap;
    private final List<Player> players;
    private final DiceRollBehaviour diceRollBehaviour;

    public Game(int gameSize, Map<Integer, GameElement> elementsMap, List<Player> players, DiceRollBehaviour diceRollBehaviour) {
        this.gameSize = gameSize;
        this.elementsMap = elementsMap;
        this.players = players;
        this.diceRollBehaviour = diceRollBehaviour;
    }

    public int getGameSize() {
        return this.gameSize;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Map<Integer, GameElement> getElementsMap() {
        return this.elementsMap;
    }

    public void rollDice(Player p, int number) {
        int playerStartPosition = p.getPosition();
        this.diceRollBehaviour.rollDice(this, p, number);
        int playerEndPosition = p.getPosition();
        System.out.println(p.getName() + " rolled a " + number + " and moved from " + playerStartPosition + " to " + playerEndPosition);
    }

}
