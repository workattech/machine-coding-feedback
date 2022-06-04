package models;

public class Player {
    private String name;

    public Player(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
