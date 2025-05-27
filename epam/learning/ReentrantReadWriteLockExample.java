package epam.learning;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {

    private int unSafeVal;
    private final ReentrantReadWriteLock lock= new ReentrantReadWriteLock();

    public ReentrantReadWriteLockExample(int unSafeVal) {
        this.unSafeVal = unSafeVal;
    }

    public void increment(){
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        try{
            unSafeVal++;
        }finally {
            writeLock.unlock();
        }
    }

    public Integer getValue(){
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        try{
            return unSafeVal;
        }finally {
            readLock.unlock();
        }
    }
}
