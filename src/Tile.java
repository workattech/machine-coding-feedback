import java.util.HashSet;
import java.util.Set;

public class Tile {
    private final int tileCoordinate;
    private boolean hasSnake;
    private boolean hasLadder;
    private final Set<Player> playerSet;

    public Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
        this.hasSnake = false;
        this.hasLadder = false;
        this.playerSet = new HashSet<>();
    }

    public int getTileCoordinate() {
        return this.tileCoordinate;
    }

    public Set<Player> getPlayerSet() {
        return this.playerSet;
    }

    public boolean getHasSnake() {
        return this.hasSnake;
    }

    public boolean getHasLadder() {
        return this.hasLadder;
    }

    public void setHasSnake() {
        this.hasSnake = true;
    }

    public void setHasLadder() {
        this.hasLadder = true;
    }
}
