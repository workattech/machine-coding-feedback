public class Player {
    private String name;
    private int prevPosition;
    private int currPosition;

    public Player(String name){
        this.name = name;
        this.prevPosition = 0;
        this.currPosition = 0;
    }
    public String getName() {
        return name;
    }

    public int getPrevPosition() {
        return prevPosition;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrevPosition(int prevPosition) {
        this.prevPosition = prevPosition;
    }

    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }
}
