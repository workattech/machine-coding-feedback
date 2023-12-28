package src.splitwise;

public class DoubleHelper {
    double getTwoDigitRoundedAmount(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }
}
