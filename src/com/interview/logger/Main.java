package com.interview.logger;
public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        LogSinkObserver sinkLogger = new ConsoleLoggerSink("STDOUT SINK", LogLevelEnum.DEBUG);

        logger.addLoggerSink(sinkLogger);
        logger.setLevel(LogLevelEnum.DEBUG);
        logger.log(LogLevelEnum.INFO, "This is info message");
        logger.log(LogLevelEnum.ERROR, "This is error message");
        logger.log(LogLevelEnum.DEBUG, "This is debug message");

        sinkLogger.updateLevel(LogLevelEnum.ERROR);

        logger.log(LogLevelEnum.INFO, "This is info message");
        logger.log(LogLevelEnum.ERROR, "This is error message");
        logger.log(LogLevelEnum.DEBUG, "This is debug message");
        logger.removeLoggerSink(sinkLogger);

        logger.log(LogLevelEnum.INFO, "This is info message");
        logger.log(LogLevelEnum.ERROR, "This is error message");
        logger.log(LogLevelEnum.DEBUG, "This is debug message");
    }
}
