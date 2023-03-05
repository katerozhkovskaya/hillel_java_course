package lesson8;

public class FileMaxSizeReachedException extends RuntimeException {

    public FileMaxSizeReachedException(FileLoggerConfiguration config, long currentSize) {
        super("File exceeded max size!  maxSize: " + config.getMaxSize() + " current size: "
                + currentSize + " file path: " + config.getFilePath());
    }
}