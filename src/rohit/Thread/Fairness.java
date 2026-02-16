package rohit.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fairness {


    private final Lock fairness = new ReentrantLock(true);

    void resource(){
        fairness.lock();
        System.out.println(Thread.currentThread().getName()+" is using ");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" has used ");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" has released");
            fairness.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Fairness ex = new Fairness();
        Runnable run1 = ex::resource;
        Thread t1 = new Thread(run1,"T-A");
        Thread t2 = new Thread(run1,"T-B");
        Thread t3 = new Thread(run1,"T-C");
        Thread t4 = new Thread(run1,"T-D");
        Thread t5 = new Thread(run1,"T-E");
        Thread t6 = new Thread(run1,"T-F");
        t1.start();
        Thread.sleep(50);
        t2.start();
        Thread.sleep(50);
        t3.start();
        Thread.sleep(50);
        t4.start();
        Thread.sleep(50);
        t5.start();
        Thread.sleep(50);
        t6.start();
//        Runnable run =()->{
//            try {
//            // Simulate a long-running task
//            for (int i = 0; i < 100; i++) {
//                if (!Thread.currentThread().isInterrupted()) {
//                    System.out.println("Task was interrupted!"+i);
////                    return;  // Exit the run method
//                }
//                // Simulate work
//                Thread.sleep(100);
//            }
//            System.out.println("Task completed successfully.");
//        } catch (InterruptedException e) {
//            System.out.println("Task was interrupted during sleep.");
//            Thread.currentThread().interrupt();
//            // Restore the interrupted status
//            Thread.currentThread().interrupt();
//        }
//        };
//        Thread t =  new Thread(run);
//        t.start();
//        Thread.sleep(1000);
//        t.interrupt();
//        t.join();
    }
}
