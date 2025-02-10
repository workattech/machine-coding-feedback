package Entity;

public class Player {
    private int position;
    private String name;

    public Player(int position, String name){
        this.position =position;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
