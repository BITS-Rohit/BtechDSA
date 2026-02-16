package rohit.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

public class ReadWriteLockCounter {
    private int count =0;
    private final Logger logger = Logger.getLogger(getClass().getName());
    private final ReadWriteLock lock =  new ReentrantReadWriteLock();
    private final Lock readlock= lock.readLock();
    private final Lock writelock = lock.writeLock();

    ReadWriteLockCounter(){}

    synchronized void increment(){
        writelock.lock();
        try {
            this.count++;
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writelock.unlock();
        }
    }
    int getCount(){
        readlock.lock();
        try{
            return count;
        }finally {
            readlock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockCounter counter = new ReadWriteLockCounter();
        Runnable readtasK = () ->{
        String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println(name+" is fechting :"+counter.getCount());
//                counter.logger.info(name+" is fechting :"+counter.getCount());
            }
        };

        Runnable writetask = () ->{
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                counter.increment();
                System.out.println(name+" incremented "+counter.getCount());
            }
//            counter.logger.info(name+" incremented "+counter.getCount());
        };

        Thread A = new Thread(readtasK,"T-A");
        Thread c = new Thread(readtasK,"T-c");
        Thread B = new Thread(writetask,"T-B");

        B.start();
        A.start();
        c.start();
//        A.setPriority(7);
        B.join();
        A.join();
        c.join();
        System.out.println("FInal count : "+counter.getCount());
    }
}
