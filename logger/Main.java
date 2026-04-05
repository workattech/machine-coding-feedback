package logger;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoProcessor(new ErrorProcessor(null));
        logProcessor.log(logProcessor.ERROR, "error message");
        logProcessor.log(logProcessor.INFO, "info message");
    }
}
