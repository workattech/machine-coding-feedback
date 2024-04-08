package exception;

public class FloorOccupied extends Exception {
    String message;

    public FloorOccupied(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
