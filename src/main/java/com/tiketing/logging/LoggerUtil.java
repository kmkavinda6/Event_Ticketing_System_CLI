package com.tiketing.logging;

import java.util.logging.*;
import java.io.IOException;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("system.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }
}
