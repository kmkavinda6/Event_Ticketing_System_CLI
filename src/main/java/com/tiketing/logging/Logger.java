package com.tiketing.logging;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    public static synchronized void log(String message) {
        try (FileWriter writer = new FileWriter("system.log", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.err.println("Logging error: " + e.getMessage());
        }
    }
}
