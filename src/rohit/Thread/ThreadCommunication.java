package rohit.Thread;

class SharedRES {
    private int data;
    private boolean hasDATA;

    SharedRES() {
    }

    SharedRES(int data, boolean hasDATA) {
        this.data = data;
        this.hasDATA = hasDATA;
    }

    synchronized void produce(int value) {
        while (hasDATA) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        System.out.println("Produced : " + value);
        hasDATA = true;
        notifyAll();
    }

    synchronized void consume() {
        while (!hasDATA) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasDATA = false;
        System.out.println("Consumed : " + data);
        notifyAll();
    }
}

class Producer implements Runnable {
    private final SharedRES res;

    Producer(SharedRES res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            res.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private final SharedRES res;

    Consumer(SharedRES res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            res.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedRES res = new SharedRES();

        Thread A = new Thread(new Producer(res), "A");
        Thread B = new Thread(new Consumer(res), "B");

        A.start();
        B.start();

        System.out.println("Done");
    }
}
