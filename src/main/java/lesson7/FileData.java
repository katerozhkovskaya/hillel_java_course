package lesson7;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FileData {
    private String name;
    private long size;
    private String path;

}
