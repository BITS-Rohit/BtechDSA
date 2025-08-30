package rohit.Thread.Practice;

public class ProConSharedRes {
    public static void main(String[] args) throws InterruptedException {
        SharedRes res = new SharedRes();
        Thread X =Thread.ofVirtual()
                .name("X")
                .start(() -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            res.producer(i);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });
        Thread Y =Thread.ofVirtual()
                .name("Y")
                .start(() -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            res.consumer();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });

        X.join();
        Y.join();

    }
}
class SharedRes{
    private int data;
    private boolean hasData;

    SharedRes(){}

    synchronized void producer(int value) throws InterruptedException {
        if (hasData)wait();
        data = value;
        System.out.println("Producer: "+value);
        hasData=true;
        notifyAll();
    }

    synchronized void consumer() throws InterruptedException{
        if(!hasData) wait();
        System.out.println("Consumer: "+data);
        hasData=false;
        notifyAll();
    }

}
