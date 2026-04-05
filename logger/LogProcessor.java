package logger;

public abstract class LogProcessor {

    int INFO = 1;
    int DEBUG = 2;
    int ERROR = 3;

    LogProcessor logProcessor;


    public LogProcessor(LogProcessor logProcessor) {
        this.logProcessor = logProcessor;
    }

    public void log(int level , String message ){
         if(logProcessor!=null){
             logProcessor.log(level,message);
         }
    }
}
