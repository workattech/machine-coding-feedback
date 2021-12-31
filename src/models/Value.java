package models;

import java.util.concurrent.ThreadLocalRandom;

public class Value {
    private long number;
    public static long baseNumber;
    public static int maxPower;

    Value(long number) {
        if(number == 0) {
            long power = ThreadLocalRandom.current().nextInt(1, Value.maxPower);
            this.number = (long) Math.pow(Value.baseNumber, power);
            return;
        }
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Value{" +
                "number=" + number +
                '}';
    }

    public void increaseValue() {
        this.number = number * Value.baseNumber;
    }
}
