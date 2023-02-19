package lesson5;

import java.util.Arrays;

public class MyList implements lesson5.HillelList {

    private final int INIT_SIZE = 4;
    private String[] array = new String[INIT_SIZE];
    private int pointer = 0;

    @Override
    public void add(String item) {
        if (pointer == array.length) {
            array = Arrays.copyOf(array, array.length + 1);
        }
        array[pointer] = item;
        pointer++;
    }

    @Override
    public String remove(int index) {
        String removedEl = this.get(index);
        array = Arrays.copyOf(this.getAll(), this.size());
        for (int i = index; i < pointer - 1; i++) {
            array[i] = array[i + 1];
        }
        array = Arrays.copyOf(array, array.length - 1);
        pointer--;
        return removedEl;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i <= this.size() - 1; i++) {
            if (array[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i <= this.size() - 1; i++) {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public String[] getAll() {
        return array;
    }
}
