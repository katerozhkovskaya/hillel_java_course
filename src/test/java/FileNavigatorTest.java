import lesson7.FileData;
import lesson7.FileNavigator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileNavigatorTest {
    FileNavigator fileNavigator = new FileNavigator();
    private final static String PATH_1 = "path1";
    private final static String PATH_2 = "path2";
    private final static String PATH_3 = "path2";


    @Test
    public void checkAddToNewPath() {
        FileData file = new FileData("file.txt", 100, PATH_1);

        fileNavigator.add(PATH_1, file);
        assertEquals(fileNavigator.find(PATH_1).size(), 1);
        assertEquals(fileNavigator.find(PATH_1).get(0), file);
    }

    @Test
    public void checkAddToExistPath() {
        FileData file1 = new FileData("file1.txt", 100, PATH_1);
        FileData file2 = new FileData("file2.txt", 100, PATH_1);
        fileNavigator.add(PATH_1, file1);
        fileNavigator.add(PATH_1, file2);
        assertEquals(fileNavigator.find(PATH_1).size(), 2);
        assertTrue(fileNavigator.find(PATH_1).contains(file1));
        assertTrue(fileNavigator.find(PATH_1).contains(file2));
    }

    @Test
    public void checkFind() {
        FileData file1 = new FileData("file1.txt", 101, PATH_1);
        FileData file2 = new FileData("file2.txt", 102, PATH_1);
        FileData file3 = new FileData("file3.txt", 103, PATH_2);

        fileNavigator.add(PATH_1, file1);
        fileNavigator.add(PATH_1, file2);
        fileNavigator.add(PATH_2, file3);

        assertEquals(2, fileNavigator.find(PATH_1).size());
        assertTrue(fileNavigator.find(PATH_1).contains(file1));
        assertTrue(fileNavigator.find(PATH_1).contains(file2));

        assertEquals(1, fileNavigator.find(PATH_2).size());
        assertTrue(fileNavigator.find(PATH_2).contains(file3));

        assertNull(fileNavigator.find("resources/nofile"));
    }

    @Test
    public void testFilterBySize() {
        FileData file1 = new FileData("file1", 100, PATH_1);
        FileData file2 = new FileData("file2", 200, PATH_2);
        FileData file3 = new FileData("file3", 300, PATH_3);

        fileNavigator.add(PATH_1, file1);
        fileNavigator.add(PATH_2, file2);
        fileNavigator.add(PATH_3, file3);

        List<FileData> filteredFiles = fileNavigator.filterBySize(200);
        assertEquals(2, filteredFiles.size());
        assertTrue(filteredFiles.contains(file1));
        assertTrue(filteredFiles.contains(file2));
        assertFalse(filteredFiles.contains(file3));
    }

    @Test
    public void testRemove() {
        FileData file1 = new FileData("file1", 100, PATH_1);
        FileData file2 = new FileData("file2", 200, PATH_1);

        fileNavigator.add(file1.getPath(), file1);
        fileNavigator.add(file2.getPath(), file2);

        fileNavigator.remove(file1.getPath());
        assertNull(fileNavigator.find(file1.getPath()));
    }

    @Test
    public void testSortBySize() {
        FileData file1 = new FileData("file1", 100, PATH_1);
        FileData file2 = new FileData("file2", 200, PATH_1);
        FileData file3 = new FileData("file3", 300, PATH_2);
        FileData file4 = new FileData("file4", 400, PATH_2);

        fileNavigator.add(file1.getPath(), file1);
        fileNavigator.add(file2.getPath(), file2);
        fileNavigator.add(file3.getPath(), file3);
        fileNavigator.add(file4.getPath(), file4);

        List<FileData> sortedFiles = fileNavigator.sortBySize();
        assertEquals(file1, sortedFiles.get(0));
        assertEquals(file2, sortedFiles.get(1));
        assertEquals(file3, sortedFiles.get(2));
        assertEquals(file4, sortedFiles.get(3));
    }
}


