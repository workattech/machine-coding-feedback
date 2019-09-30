import java.util.List;

public class Player {
    private String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int rollTheDices(List<Dice> dices) {
        int delta = 0;

        for (Dice d : dices)
            delta += d.roll();


        return delta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
