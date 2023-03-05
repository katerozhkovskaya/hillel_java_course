package lesson8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class FileLoggerConfigurationLoader extends LoggerConfigurationLoaderBase{
    public FileLoggerConfiguration load() {
        Properties prop = new Properties();

        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            prop.load(input);
            String path = prop.getProperty("path");
            LoggingLevel level;
            level = LoggingLevel.valueOf(prop.getProperty("level"));
            long maxSize = Long.parseLong(prop.getProperty("max-size"));
            if (path == null) {
                throw new IllegalArgumentException("Invalid configuration file: " + CONFIG_FILE);
            }
            return new FileLoggerConfiguration(path, level, maxSize);
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException("Can't read properties file: " + CONFIG_FILE, e);
        }
    }
}
