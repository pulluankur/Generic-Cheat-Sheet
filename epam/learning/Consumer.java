package epam.learning;

public class Consumer implements Runnable{

    private final ProdCons prodCons;

    public Consumer(ProdCons prodCons) {
        this.prodCons = prodCons;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                prodCons.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
