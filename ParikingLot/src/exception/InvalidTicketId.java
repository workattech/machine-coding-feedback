package exception;

public class InvalidTicketId extends Exception {
    String message;

    public InvalidTicketId(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
