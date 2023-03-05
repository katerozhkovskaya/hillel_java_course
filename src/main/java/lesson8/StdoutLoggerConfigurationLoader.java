package lesson8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StdoutLoggerConfigurationLoader extends LoggerConfigurationLoaderBase{
    StdoutLoggerConfiguration load() {
        Properties prop = new Properties();

        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            prop.load(input);
            LoggingLevel level;
            level = LoggingLevel.valueOf(prop.getProperty("level"));
            return new StdoutLoggerConfiguration(level);
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException("Can't read properties file: " + CONFIG_FILE, e);
        }
    }
}

