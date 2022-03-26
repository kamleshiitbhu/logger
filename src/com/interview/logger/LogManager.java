package com.interview.logger;
import java.util.LinkedList;
import java.util.Queue;

public class LogManager {
    LoggerSubject loggerSubject;
    Logging logging;
//    Queue<Integer> buffer;
    LogManager() {
        loggerSubject = new LoggerSubject();
        logging = new Logging();
//        buffer = new LinkedList<>();
    }

    public LoggerSubject getLoggerSubject() {
        return loggerSubject;
    }

    public Logging getLogging() {
        return logging;
    }

    public void  addObservers(LogSinkObserver logSinkObserver){
        loggerSubject.addObserver(logSinkObserver);
    }

    public void removeObserver(LogSinkObserver logSinkObserver) {
        loggerSubject.removeObserver(logSinkObserver);
    }
}

