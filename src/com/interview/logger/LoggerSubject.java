package com.interview.logger;

import java.util.ArrayList;

public class LoggerSubject {
    ArrayList<LogSinkObserver> logObservers = new ArrayList<>();

    void addObserver(LogSinkObserver logObserver){
        logObservers.add(logObserver);
    }

    void removeObserver(LogSinkObserver logObserver){
        logObservers.remove(logObserver);
    }

    void notifyAllObserver(LogLevelEnum level, String message){
        for (LogSinkObserver logSinkObserver: logObservers) {
            if (logSinkObserver.getLevel().ordinal() >= level.ordinal()) {
                logSinkObserver.log(message);
            }
        }
    }
}
