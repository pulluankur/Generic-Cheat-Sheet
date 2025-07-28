package epam.learning.ProdConsSemaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{

    private final Store store;
    private Semaphore prodSema;
    private Semaphore consSema;

    private static AtomicInteger itemCounter=new AtomicInteger(1);
    public Producer(Store store, Semaphore prodSema, Semaphore consSema) {
        this.store =  store;
        this.prodSema = prodSema;
        this.consSema = consSema;
    }

    @Override
    public void run() {

       while (true){
           try {
               prodSema.acquire();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           store.addItem(itemCounter.get());
           itemCounter.getAndIncrement();
           consSema.release();
       }
    }
}
