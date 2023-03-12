package lesson12;


import java.util.Arrays;

public class MyGenericList<T> implements GenericHillelList<T> {

    private final int INIT_SIZE = 4;
    private T[] array = (T[]) new Object[INIT_SIZE];
    private int pointer = 0;

    @Override
    public void add(T item) {
        if (pointer == array.length) {
            array = Arrays.copyOf(array, array.length + 1);
        }
        array[pointer] = item;
        pointer++;
    }


    @Override
    public T remove(int index) {
        T removedEl = this.get(index);
        array = (T[]) Arrays.copyOf(this.getAll(), this.size());
        for (int i = index; i < pointer - 1; i++) {
            array[i] = array[i + 1];
        }
        array = Arrays.copyOf(array, array.length - 1);
        pointer--;
        return removedEl;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i <= this.size() - 1; i++) {
            if (array[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(T item) {
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
    public T get(int index) {
        return array[index];
    }

    @Override
    public Object[] getAll() {
        return array;
    }
}
