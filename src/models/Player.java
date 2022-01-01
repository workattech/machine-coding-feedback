package models;

public class Player extends BaseModel {
    private String name;

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
    }
}
