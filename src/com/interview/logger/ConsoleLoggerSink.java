package com.interview.logger;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.io.*;

public class ConsoleLoggerSink implements LogSinkObserver {
    ArrayList<String> logMessage;
    String name;
    LogLevelEnum sinkLevel;
    String fileName;
    FileOutputStream outputStream;
    @Override
    public LogLevelEnum getLevel() {
        return sinkLevel;
    }

    @Override
    public void updateLevel(LogLevelEnum level) {
        this.sinkLevel = level;
    }

    ConsoleLoggerSink(String name, LogLevelEnum level) {
        this.name = name;
        this.sinkLevel = level;
        logMessage = new ArrayList<>();
        fileName = name + ".txt";
        try {
            outputStream = new FileOutputStream(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void finalize() {
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();;
        }

    }
    @Override
    public void log(String message) {
        System.out.println("Writing to stdout to sink " + this.name + " : " + message);
        try {
            outputStream.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        logMessage.add(message);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ConsoleLoggerSink sinkObserver = (ConsoleLoggerSink)obj;
        return sinkObserver.name == this.name && sinkObserver.sinkLevel == this.sinkLevel;
    }
}