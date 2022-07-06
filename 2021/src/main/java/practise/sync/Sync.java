package practise.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Supplier;

public class Sync {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public <T> T read(Supplier<T> supplier) {
        Lock lock = readWriteLock.readLock();
        lock.lock();
        try {
            return supplier.get();
        } finally {
            lock.unlock();
        }
    }

    public <T> T write(Supplier<T> supplier) {
        Lock lock = readWriteLock.writeLock();
        lock.lock();
        try {
            return supplier.get();
        } finally {
            lock.unlock();
        }
    }
}
