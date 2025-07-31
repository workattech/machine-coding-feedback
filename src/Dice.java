import java.util.Random;

public class Dice {
    private final Random random = new Random();
    private final int diceCount;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }


    public int rollDice(){
        int total = 0;
        for(int i=0; i<diceCount; i++){
            total += random.nextInt(6)+1;
        }
        return total;
    }
}