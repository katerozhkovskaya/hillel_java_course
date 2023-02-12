import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MyLessonFiveTest {
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
        assertThat(startSize + 1).isEqualTo(list.size());
        assertThat(list.contains("5")).isTrue();
        list.add("6");
        assertThat(startSize + 2).isEqualTo(list.size());
        assertThat(list.contains("5")).isTrue();
    }

    @Test
    public void checkRemove() {
        int startSize = list.size();
        list.remove(2);
        assertThat(startSize - 1).isEqualTo(list.size());
        assertThat(list.contains("3")).isFalse();
    }

    @Test
    public void checkContains() {
        assertThat(list.contains("2")).isTrue();
        assertThat(list.contains("9")).isFalse();
    }

    @Test
    public void checkIndexOf() {
        assertThat(list.indexOf("2")).isEqualTo(1);
        assertThat(list.indexOf("9")).isEqualTo(-1);
    }

    @Test
    public void checkSize() {
        assertThat(list.size()).isEqualTo(4);
        list.add("5");
        assertThat(list.size()).isEqualTo(5);
        list.remove(4);
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void checkGet() {
        assertThat(list.get(0)).isEqualTo("1");
        assertThat(list.get(3)).isEqualTo("4");
    }

    @Test
    public void checkGetAll() {
        String[] actualArray = list.getAll();
        assertArrayEquals(actualArray, new String[]{"1", "2", "3", "4"});
    }
}
