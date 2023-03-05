package lesson8;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration config = loader.load();
        var logger = new FileLogger(config);
        StdoutLoggerConfigurationLoader loader1 = new StdoutLoggerConfigurationLoader();
        StdoutLoggerConfiguration config1 = loader1.load();
        var logger1 = new StdoutLogger(config1);

        logger.debug("Try log debug with method debug");
        logger.info("Try log info with method info");
        logger1.debug("Try log debug with method debug");
        logger1.info("Try log info with method info");
    }
}

