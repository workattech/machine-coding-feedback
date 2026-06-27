package snake_ladder.behaviours;

import snake_ladder.entities.Game;
import snake_ladder.entities.GameElement;
import snake_ladder.entities.Player;

import java.util.Map;

public class SimpleDiceRollBehaviour implements DiceRollBehaviour{

    public void rollDice(Game game, Player player, int number) {
        int gameSize = game.getGameSize();

        int playerPosition = player.getPosition();
        int endPosition = playerPosition + number;

        if (endPosition > gameSize) {
            return;
        }

        Map<Integer, GameElement> gameElementMap = game.getElementsMap();

        while (gameElementMap.containsKey(endPosition)) {
            GameElement gameElement = gameElementMap.get(endPosition);
            endPosition = gameElement.act();
        }

        player.setPosition(endPosition);
    }

}
