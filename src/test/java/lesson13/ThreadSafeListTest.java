package lesson13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadSafeListTest {

    @Test
    void checkAdd() {
        ThreadSafeList<String> list = new ThreadSafeList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        assertEquals("test1", list.get(0));
        assertEquals("test2", list.get(1));
        assertEquals("test3", list.get(2));
    }

    @Test
    void checkRemove() {
        ThreadSafeList<String> list = new ThreadSafeList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.remove(1);
        assertEquals("test1", list.get(0));
        assertEquals("test3", list.get(1));
    }

    @Test
    void checkGet() {
        ThreadSafeList<String> list = new ThreadSafeList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        assertEquals("test1", list.get(0));
        assertEquals("test2", list.get(1));
        assertEquals("test3", list.get(2));
    }

}
