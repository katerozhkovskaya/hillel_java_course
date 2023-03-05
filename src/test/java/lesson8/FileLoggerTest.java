package lesson8;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileLoggerTest {
    private static final String LOG_FILE_PATH = "test";
    private static final int MAX_SIZE = 100;
    private FileLogger fileLogger;
    private File logFile = new File(LOG_FILE_PATH);


    @Test
    public void checkLogMethod() {
        String message = "Test message";
        fileLogger.log(message, LoggingLevel.DEBUG);
        assertEquals(LOG_FILE_PATH, logFile.getPath());
        assertTrue(FileUtils.sizeOf(FileUtils.getFile("test.log")) > 0);
    }

    @BeforeEach
    public void setup() throws Exception {
        if (FileUtils.getFile("test.log").exists()) {
            FileUtils.forceDelete(FileUtils.getFile("test.log"));
        }
        FileLoggerConfiguration config = new FileLoggerConfiguration(LOG_FILE_PATH, LoggingLevel.DEBUG, MAX_SIZE);
        fileLogger = new FileLogger(config);
        logFile = new File(LOG_FILE_PATH);
    }

    @Test
    public void checkLoadMethod() {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration result = loader.load();

        assertEquals("logs-file", result.getFilePath());
        assertEquals(LoggingLevel.DEBUG, result.getLevel());
        assertEquals(10, result.getMaxSize());
    }
}