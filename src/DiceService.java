public class DiceService {
    int maxNumber;

    public DiceService(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int run() {
        return (int)(Math.random() * maxNumber) + 1;
    }
}
