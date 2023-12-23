import java.util.List;

public class Board {
    private int size;
    private Entities snakes;
    private Ladders ladders;
    private Dices dices;
    private List<Player> players;

    public Board(int size, Entities snakes, Ladders ladders, Dices dices, List<Player> players) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.dices = dices;
        this.players = players;
    }

    public void run() {
        Boolean gameRunning = true;
        while (gameRunning) {
            for (int i = 0; i < players.size(); ++i) {
                Player player = players.get(i);
                Integer curPosition = player.getPosition();
                Integer diceValue = dices.throwChance();
                Integer newPosition = curPosition + diceValue;
                if (newPosition > size)
                    continue;
                while (snakes.isPresent(newPosition) || ladders.isPresent(newPosition)) {
                    if (snakes.isPresent(newPosition)) {
                        newPosition = snakes.getNextValue(newPosition);
                    }
                    if (ladders.isPresent(newPosition)) {
                        newPosition = ladders.getNextValue(newPosition);
                    }
                }
                System.out.println(String.format("%s rolled a %d and moved from %d to %d", player.getName(), diceValue,
                        curPosition, newPosition));
                player.setPosition(newPosition);
                if (newPosition == size) {
                    System.out.println(String.format("%s wins the game", player.getName()));
                    gameRunning = false;
                    break;
                }
            }
        }
    }
}
