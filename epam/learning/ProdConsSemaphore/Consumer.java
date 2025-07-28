package epam.learning.ProdConsSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private final Store store;
    private Semaphore prodSema;
    private Semaphore consSema;

    public Consumer(Store store, Semaphore prodSema, Semaphore consSema) {
    this.store = store;
        this.prodSema = prodSema;
        this.consSema = consSema;
    }

    @Override
    public void run() {
        while(true){
            try {
                consSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            store.removeItem();
            prodSema.release();
        }
    }
}
