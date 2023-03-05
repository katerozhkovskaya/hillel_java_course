package lesson8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger {

    private static final String FILE_EXTENSION = ".log";
    private final FileLoggerConfiguration config;
    private File currentFile;
    private FileWriter currentFileWriter;

    public FileLogger(FileLoggerConfiguration config) throws FileMaxSizeReachedException, IOException {
        this.config = config;
        this.currentFile = new File(config.getFilePath() + FILE_EXTENSION);
        this.currentFileWriter = new FileWriter(currentFile, true);
    }

    @Override
    public void debug(String message) {
        log(message, LoggingLevel.DEBUG);
    }

    @Override
    public void info(String message) {
        log(message, LoggingLevel.INFO);
    }

    void log(String message, LoggingLevel level) {
        if (level == LoggingLevel.DEBUG && config.getLevel() != LoggingLevel.DEBUG) {
            return;
        }

        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logMessage = String.format("[%s][%s] Message: %s\n", time, level, message);

        try {
            if (currentFile.length() + logMessage.getBytes().length > config.getMaxSize()) {
                createNewFile();
            }
            currentFileWriter.write(logMessage);
            currentFileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write message in file!", e);
        }
    }

    private void createNewFile() throws IOException {
        currentFileWriter.close();
        String time = new SimpleDateFormat("dd.MM.yyyy-HH.mm").format(new Date());
        String fileName = time + FILE_EXTENSION;
        currentFile = new File(fileName);
        currentFileWriter = new FileWriter(currentFile, true);
    }
}
