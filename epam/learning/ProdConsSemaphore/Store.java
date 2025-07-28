package epam.learning.ProdConsSemaphore;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {

    private final Integer MAX_SIZE;
    private ConcurrentLinkedQueue<Integer> items;

    Store(int size){
        this.MAX_SIZE =  size;
        items = new ConcurrentLinkedQueue<>();
    }

    public int getMaxSize(){
        return MAX_SIZE;
    }

    public void addItem(Integer item){
        items.add(item);
        System.out.println("item is produced:"+ items.size());
    }

    public void removeItem(){
        System.out.println("item is consumed:"+ items.size());
        items.remove();
    }



}
