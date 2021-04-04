import java.util.Random;

public class Dice {
    public  static Integer rollTheDice(){
        Random random  = new Random();
        Integer randomNumber = random.nextInt(5);
        return randomNumber+1;
    }
}


