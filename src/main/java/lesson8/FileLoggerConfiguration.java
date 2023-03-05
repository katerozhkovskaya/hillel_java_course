package lesson8;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel level;
    private long maxSize;
}
