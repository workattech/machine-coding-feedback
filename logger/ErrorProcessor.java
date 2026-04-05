package logger;


public class ErrorProcessor extends LogProcessor{
    public ErrorProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int log, String message){
        if(log == ERROR){
            System.out.println("ERROR::"+message);
        }
        else {
            super.log(log,message);
        }

    }
}
