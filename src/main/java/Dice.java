import java.util.Random;

public class Dice {
    private Random rand;
    private int min;
    private int max;

    public Dice(int min,int max){
        this.rand = new Random();
        this.min = min;
        this.max = max;
    }
    public int roll(){
        return rand.ints(min,max+1).findFirst().getAsInt();
    }
}
