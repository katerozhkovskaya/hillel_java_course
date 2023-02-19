import lesson5.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLessonSevenTest {
    MyList list = new MyList();

    @BeforeEach
    void fillList() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    }

    @Test
    public void checkAdd() {
        int startSize = list.size();
        list.add("5");
        assertEquals((startSize + 1), list.size());
        assertTrue(list.contains("5"));
        list.add("6");
        assertEquals((startSize + 2), list.size());
        assertTrue(list.contains("5"));
    }

    @Test
    public void checkRemove() {
        int startSize = list.size();
        list.remove(2);
        assertEquals(startSize - 1, list.size());
        assertFalse(list.contains("3"));
    }

    @Test
    public void checkContains() {
        assertTrue(list.contains("2"));
        assertFalse(list.contains("9"));
    }

    @Test
    public void checkIndexOf() {
        assertEquals(list.indexOf("2"), 1);
        assertEquals(list.indexOf("9"), -1);
    }

    @Test
    public void checkSize() {
        assertEquals(list.size(), 4);
        list.add("5");
        assertEquals(list.size(), 5);
        list.remove(4);
        assertEquals(list.size(), 4);
    }

    @Test
    public void checkGet() {
        assertEquals(list.get(0), "1");
        assertEquals(list.get(3), "4");
    }

    @Test
    public void checkGetAll() {
        String[] actualArray = list.getAll();
        assertArrayEquals(actualArray, new String[]{"1", "2", "3", "4"});
    }
}
