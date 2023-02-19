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
        List<FileData> result = new ArrayList<>();
        for (List<FileData> files : filesByPath.values()) {
            for (FileData file : files) {
                if (file.getSize() <= maxSize) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        filesByPath.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> files : filesByPath.values()) {
            result.addAll(files);
        }
        result.sort(Comparator.comparingInt((FileData::getSize)));
        return result;
    }
}
