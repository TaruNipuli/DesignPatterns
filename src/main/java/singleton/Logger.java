package singleton;

import java.io.FileWriter;

public class Logger {
    public static Logger instance; // Singleton instance of Logger
    private FileWriter fileWriter; // File writer for logging to a file
    private String logFile; // Log file name

    // Private constructor
    private Logger(String logFile) {
        this.logFile = logFile; // Set log file name
        try { // Append mode = new messages are added to the end of the file
            fileWriter = new FileWriter(logFile, true); // Open file in append mode (true = add new messages to the end)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get the singleton instance
    public static Logger getInstance(String logFile) {
        if (instance == null) {
            instance = new Logger(logFile); // If instance doesn't exist, create it with the given log file
        }
        return instance;
    }

    // Method to log a message to the file
    public void log(String message) {
        try {
            fileWriter.write(message + "\n");  // Write the message
            fileWriter.flush(); // Ensure the message is immediately written to file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to change the log file name
    public void setFileName(String newFileName) {
        try {
            if (fileWriter != null) {
                fileWriter.close(); // Close current file before opening a new one
            }
            this.logFile = newFileName; // Update the log file name
            fileWriter = new FileWriter(logFile, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to close the file writer
    public void close() {
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}