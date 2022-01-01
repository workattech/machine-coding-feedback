package models;

public class Tile {
    private Value value;

    public Tile() {
        this.value = new Value(0);
    }

    public Tile(long number) {
        this.value = new Value(number);
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "value=" + value +
                '}';
    }

    public boolean isSimilarTo(Tile tile) {
        return this.getValue().getNumber() == tile.getValue().getNumber();
    }
}
