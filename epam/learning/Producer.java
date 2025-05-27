package epam.learning;

public class Producer implements Runnable{

    private final ProdCons prodCons;

    public Producer(ProdCons prodCons) {
        this.prodCons = prodCons;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                prodCons.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
