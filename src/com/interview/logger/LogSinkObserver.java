package com.interview.logger;

public interface LogSinkObserver {
    void log(String message);
    LogLevelEnum getLevel();
    void updateLevel(LogLevelEnum level);
}
