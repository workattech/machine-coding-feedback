import java.util.Random;

/**
 * Created by Shreyansh97 on 7/9/19
 */

public class Dice {
  private int count;
  private Random random;
  
  public Dice(int count) {
    this.count = count;
    random = new Random(System.currentTimeMillis());
  }
  
  public int roll() {
    int from = count;
    int to = count * 6;
    return Math.min(random.nextInt(to-from+1) + from, to);
  }
}
