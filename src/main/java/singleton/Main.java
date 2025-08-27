package singleton;

public class Main {
    public static void main(String[] args) {
        // Get the singleton Logger instance with log file "log.txt"
        Logger logger = Logger.getInstance("log.txt");

        // Log some messages to the initial file
        logger.log("Simulation started");             // Write first log message
        logger.log("Processing data...");             // Write processing message
        logger.log("Simulation finished");            // Write final message

        // Change the log file to "new_log.txt"
        logger.setFileName("new_log.txt");
        logger.log("This message goes to new_log.txt"); // Write message to the new file

        // Close the logger to release file resources
        logger.close();
    }
}
