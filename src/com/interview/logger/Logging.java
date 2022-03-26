package com.interview.logger;
public class Logging {
    public void logMesssage(LogLevelEnum level, String msg, LoggerSubject loggerSubject) {
        loggerSubject.notifyAllObserver(level, msg);
    }
}
