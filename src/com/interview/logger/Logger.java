package com.interview.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.*;

public class Logger {
    private static Logger logger;
    private static LogManager logManager;
    private LogLevelEnum level;
    private String format;

    private Logger () {
        try {
            FileReader reader=new FileReader("resources/config.properties");
            Properties p=new Properties();
            p.load(reader);
            this.level = LogLevelEnum.valueOf(p.getProperty("log_level", "INFO"));
            this.format = p.getProperty("format", "yyyy-MM-dd HH:mm:ss");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LogLevelEnum getLevel() {
        return this.level;
    }

    public void updateDateFormat(String newFormat) {
        synchronized (this) {
            this.format = newFormat;
        }
    }

    public void setLevel(LogLevelEnum newLevel) {
        synchronized (this) {
            this.level = newLevel;
        }
    }

    public void addLoggerSink(LogSinkObserver logSink) {
        synchronized (this) {
            logManager.addObservers(logSink);
        }
    }

    public void removeLoggerSink(LogSinkObserver logSinkObserver) {
        synchronized (this) {
            logManager.removeObserver(logSinkObserver);
        }
    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                logger = new Logger();
                logManager = new LogManager();
            }
        }
        return logger;
    }

    public String getCurrentTimeStamp() {
        SimpleDateFormat formatter = new SimpleDateFormat(this.format);
        return formatter.format(new Date());
    }

    public void log(LogLevelEnum messageLogLevel, String msg) {
        if (this.level.ordinal() >= messageLogLevel.ordinal()) {
            String message = messageLogLevel.name() + " " + getCurrentTimeStamp() + ": " + msg + "\n";
            logManager.getLogging().logMesssage(messageLogLevel, message, logManager.getLoggerSubject());
        }
    }
}
