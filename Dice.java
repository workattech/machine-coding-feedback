import java.util.Random;

class Dice
{
    Random rand = new Random();

    int rollDice() {
        return rand.nextInt(6) + 1; // Generates 1 to 6
    }
    
}