package epam.learning;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProdCons {

    private final Queue<Integer> buffer = new LinkedList<>();
    private static final Integer MAX_SIZE=5;

    public synchronized void produce(int data) throws InterruptedException {

        while(buffer.size()== MAX_SIZE)
            wait();
        buffer.add(data);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while(buffer.size()==0)
            wait();
        Integer data = buffer.poll();
        System.out.println("data:"+data);
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread t1= new Thread(new Producer(new ProdCons()));
//        Thread t2= new Thread(new Consumer(new ProdCons()));
//        t1.start();
//        t2.start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Producer(new ProdCons()));
        executorService.submit(new Consumer(new ProdCons()));



    }
}
