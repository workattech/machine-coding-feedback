class Move {
    private final int initialPos;
    private final int finalPos;

    public Move(int initialPos, int finalPos) {
        this.initialPos = initialPos;
        this.finalPos = finalPos;
    }

    public int getFinalPos() {
        return finalPos;
    }

    public int getInitialPos() {
        return initialPos;
    }
}