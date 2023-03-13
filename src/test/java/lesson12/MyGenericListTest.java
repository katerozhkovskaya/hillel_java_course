package lesson12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyGenericListTest {
    MyGenericList<String> list1 = new MyGenericList();
    MyGenericList<Integer> list2 = new MyGenericList();

    @BeforeEach
    void fillList() {
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
    }

    @Test
    public void checkAdd() {
        int startSize = list1.size();
        list1.add("5");
        list2.add(5);
        assertEquals((startSize + 1), list1.size());
        assertTrue(list1.contains("5"));
        assertEquals((startSize + 1), list2.size());
        assertTrue(list2.contains(5));
        list1.add("6");
        list2.add(6);
        assertEquals((startSize + 2), list1.size());
        assertTrue(list1.contains("6"));
        assertEquals((startSize + 2), list2.size());
        assertTrue(list2.contains(6));
    }

    @Test
    public void checkRemove() {
        int startSize = list1.size();
        list1.remove(2);
        list2.remove(2);
        assertEquals(startSize - 1, list1.size());
        assertFalse(list1.contains("3"));
        assertEquals(startSize - 1, list2.size());
        assertFalse(list2.contains(3));
    }

    @Test
    public void checkContains() {
        assertTrue(list1.contains("2"));
        assertFalse(list1.contains("9"));
        assertTrue(list2.contains(2));
        assertFalse(list2.contains(9));
    }

    @Test
    public void checkIndexOf() {
        assertEquals(list1.indexOf("2"), 1);
        assertEquals(list1.indexOf("9"), -1);
        assertEquals(list2.indexOf(2), 1);
        assertEquals(list2.indexOf(9), -1);
    }

    @Test
    public void checkSize() {
        assertEquals(list1.size(), 4);
        list1.add("5");
        assertEquals(list1.size(), 5);
        list1.remove(4);
        assertEquals(list1.size(), 4);
        assertEquals(list2.size(), 4);
        list2.add(5);
        assertEquals(list2.size(), 5);
        list2.remove(4);
        assertEquals(list2.size(), 4);
    }

    @Test
    public void checkGet() {
        assertEquals(list1.get(0), "1");
        assertEquals(list1.get(3), "4");
        assertEquals(list2.get(0), 1);
        assertEquals(list2.get(3), 4);
    }

    @Test
    public void checkGetAll() {
        Object[] actualArray1 = list1.getAll();
        assertArrayEquals(actualArray1, new String[]{"1", "2", "3", "4"});
        Object[] actualArray2 = list2.getAll();
        assertArrayEquals(actualArray2, new Integer[]{1, 2, 3, 4});
    }
}
