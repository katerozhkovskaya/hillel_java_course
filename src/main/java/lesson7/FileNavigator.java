package lesson7;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> filesByPath;

    public FileNavigator() {
        filesByPath = new HashMap<>();
    }

    public void add(String path, FileData file) {
        try {
            if (!file.getPath().equals(path)) {
                throw new PathNotEqualFilePathException("Шлях-ключ і шлях до файлу не збігаються");
            }
            if (!filesByPath.containsKey(path)) {
                List<FileData> filesList = new ArrayList();
                filesList.add(file);
                filesByPath.put(path, filesList);
            } else {
                List<FileData> filesList = filesByPath.get(path);
                filesList.add(file);
            }
        } catch (PathNotEqualFilePathException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<FileData> find(String path) {
        return filesByPath.get(path);
    }

    public List<FileData> filterBySize(long maxSize) {
        return filesByPath.values().stream()
                .flatMap(Collection::stream)
                .filter(file -> file.getSize() <= maxSize)
                .toList();
    }

    public void remove(String path) {
        filesByPath.remove(path);
    }

    public List<FileData> sortBySize() {
        return filesByPath.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(FileData::getSize))
                .toList();
    }
}
