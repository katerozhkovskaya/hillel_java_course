package lesson12;

public interface GenericHillelList<T> {

    void add(T item);

    T remove(int index);

    boolean contains(T item);

    int indexOf(T item);

    int size();

    T get(int index);

    Object[] getAll();}
