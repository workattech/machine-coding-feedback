public class Cell {
    private int mSnakeId = -1;
    private int mLadderId = -1;

    public void setLadderId(int ladderId) {
        mLadderId = ladderId;
    }

    public void setSnakeId(int snakeId) {
        mSnakeId = snakeId;
    }

    public int getLadderId() {
        return mLadderId;
    }

    public int getSnakeId() {
        return mSnakeId;
    }
}
