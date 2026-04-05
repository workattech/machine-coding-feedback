package DeckOfCards;

public enum Suit {
    SPADE(0),
    HEART(1),
    CLUB(2),
    DIAMOND(3);
    private final int value;

    private Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
