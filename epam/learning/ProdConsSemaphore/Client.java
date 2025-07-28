package epam.learning.ProdConsSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        Store store = new Store(5);

        Semaphore prodSema = new Semaphore(store.getMaxSize());
        Semaphore consSema = new Semaphore(0);


        for(int i=0; i<4; i++){
            Producer producer = new Producer(store, prodSema, consSema);
            threadPool.execute(producer);
        }

        for(int i=0; i<16; i++){
            Consumer consumer = new Consumer(store, prodSema, consSema);
            threadPool.execute(consumer);
        }
    }

}
