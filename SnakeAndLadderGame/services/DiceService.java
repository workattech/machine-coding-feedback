package services;

class DiceService {
    final private int DEFAULT_NUMBER_OF_SIDES_OF_DICE = 6;
    public int roll() {
        int rollValue = (int)(1 + DEFAULT_NUMBER_OF_SIDES_OF_DICE * Math.random());
        return rollValue;
    }
}