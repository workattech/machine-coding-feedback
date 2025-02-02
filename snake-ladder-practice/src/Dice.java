import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public int roll(){
        return ThreadLocalRandom.current().nextInt(1,7);
    }
}
