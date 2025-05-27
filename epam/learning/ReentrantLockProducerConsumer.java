package epam.learning;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockProducerConsumer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private static final Integer SIZE = 5;
    private final Lock lock = new ReentrantLock();
    private final Condition prodCond = lock.newCondition();
    private final Condition consCond = lock.newCondition();

    public ReentrantLockProducerConsumer() {

    }

    public void addData(Integer data){ //producer
        lock.lock();
        try {
            while(buffer.size() == SIZE)
                prodCond.await();
            buffer.offer(data);
            consCond.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public Integer getVal(){  //consumer
        lock.lock();
        try {
            while(buffer.isEmpty())
                consCond.await();
            Integer data = buffer.poll();
            prodCond.signal();
            return data;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
