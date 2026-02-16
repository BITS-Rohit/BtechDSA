package rohit.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class ReentrantLockexample {
    private final Logger log = Logger.getLogger(getClass().getName());
    private final Lock lock = new ReentrantLock();
    Runnable t1 = () -> System.out.println(lock);
    Thread t2 = new Thread(t1);
    String  t3 = String.valueOf(t2.getState());
    void outerclass(){
        lock.lock();
        try {
            System.out.println("Outer lock");
            System.out.println(Thread.currentThread().getState());
            System.out.println(t3);
            t2.start();
            innermethod();
        }finally {
            lock.unlock();
        }
    }

    void innermethod() {
        lock.lock();
        try {
            t2.join();
            System.out.println("Inner lock");
            System.out.println(Thread.currentThread().getState());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockexample lock = new ReentrantLockexample();
        lock.outerclass();
    }
}
