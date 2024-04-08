package exception;

public class InvalidMove extends RuntimeException {
    private String message;

    public InvalidMove(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
