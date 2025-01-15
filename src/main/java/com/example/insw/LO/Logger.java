package com.example.insw.LO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;

    public enum LogLevel {
        DEBUG, INFO, WARNING, ERROR
    }

    private LogLevel currentLogLevel = LogLevel.INFO;

    private Logger() {
        try {
            FileWriter fileWriter = new FileWriter("output.txt", true);
            writer = new PrintWriter(fileWriter, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setLogLevel(LogLevel level) {
        this.currentLogLevel = level;
    }

    public void log(LogLevel level, String mensaje) {
        if (level.ordinal() >= currentLogLevel.ordinal()) {
            String logMessage = "[" + java.time.LocalTime.now() + "][" + level + "] " + mensaje;
            // Scrive nel file
            writer.println(logMessage);
        }
    }

    public void log(String mensaje) {
        log(LogLevel.INFO, mensaje);
    }

    public void debug(String mensaje) {
        log(LogLevel.DEBUG, mensaje);
    }

    public void info(String mensaje) {
        log(LogLevel.INFO, mensaje);
    }

    public void warning(String mensaje) {
        log(LogLevel.WARNING, mensaje);
    }

    public void error(String mensaje) {
        log(LogLevel.ERROR, mensaje);
    }
}