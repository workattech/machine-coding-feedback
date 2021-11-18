public class Player {

    private String name;
    private int currentPosition;

    public Player(String name, int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    // This is a function that will update the current location of the players.
    public void updateLocation(int newValue){
        this.currentPosition = newValue;
    }


}
