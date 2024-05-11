package model;

public class User {

    private int userId;
    private String userName;
    private int positionBeforeThreeMoves;
    private int continuousMax;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.positionBeforeThreeMoves = 0;
        this.continuousMax = 0;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPositionBeforeThreeMoves() {
        return positionBeforeThreeMoves;
    }

    public void setPositionBeforeThreeMoves(int positionBeforeThreeMoves) {
        this.positionBeforeThreeMoves = positionBeforeThreeMoves;
    }

    public int getContinuousMax() {
        return continuousMax;
    }

    public void incrementContinuousMax() {
        this.continuousMax += 1;
    }

    public void resetContinuousMax() {
        this.continuousMax = 0;
    }
}
