import java.util.Random;

public class Dice {
    private int min;
    private int max;

    private Random random;
    public Dice(int min, int max){
        this.min = min;
        this.max = max;
        random = new Random();
    }
    public int rollDice(){
        return min + random.nextInt(max);
    }
}
