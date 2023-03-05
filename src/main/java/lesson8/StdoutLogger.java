package lesson8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdoutLogger implements Logger {

    private final StdoutLoggerConfiguration config;

    public StdoutLogger(StdoutLoggerConfiguration config) {
        this.config = config;
    }

    @Override
    public void debug(String message) {
        log(message, LoggingLevel.DEBUG);
    }

    @Override
    public void info(String message) {
        log(message, LoggingLevel.INFO);
    }

    private void log(String message, LoggingLevel level) {
        if (level == LoggingLevel.DEBUG && config.getLevel() != LoggingLevel.DEBUG) {
            return;
        }

        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logMessage = String.format("[%s][%s] Message: %s\n", time, level, message);
        System.out.println(logMessage);
    }
}
