package logger;

public class InfoProcessor extends LogProcessor{
    public InfoProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int log, String message){
        if(log == INFO){
            System.out.println("Info::"+message);
        }
        else {
            super.log(log,message);
        }
    }
}
