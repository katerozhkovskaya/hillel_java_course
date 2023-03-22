package lesson13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T> {

    private final List<T> list;
    private final ReadWriteLock lock;

    public ThreadSafeList() {
        this.list = new ArrayList<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public void add(T value) {
        lock.writeLock().lock();
        try {
            list.add(value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T remove(int index) {
        lock.writeLock().lock();
        try {
            return list.remove(index);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T get(int index) {
        lock.readLock().lock();
        try {
            return list.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }
}
