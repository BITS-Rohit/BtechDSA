package rohit.Thread;

import java.math.BigInteger;
import java.util.logging.Logger;

public class MyThread extends Thread {
    private static final Logger logger = Logger.getLogger(MyThread.class.getName());
    MyThread(String name){
        super(name);
    }
    public void run() {
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 2000000; j++) {
//                j=j++;
//            }
//        System.out.println
//                (Thread.currentThread().getName()+" Priority "+
//                        Thread.currentThread().getPriority()+" Count "+ i);
//        }

//        System.out.println("Running is here ..... ");
        BigInteger big = BigInteger.ONE;
        BigInteger b = new BigInteger("1");
        for(;;){
            big=big.add(BigInteger.ONE);
            System.out.println(Thread.currentThread().getName()+ " is running "+big);
            Thread.yield();
        }
//        try {
//            Thread.sleep(100);
////            System.out.println("RUNNING");
//        }
//        catch (Exception e){
//            logger.log(Level.SEVERE,"Exception : ",e);
//        }
    }
    public static void main(String[] args) throws InterruptedException{
        MyThread t1 = new MyThread("Radhe");
        t1.setDaemon(true);
        t1.start();
        t1.join();
        System.out.println("Main thread is Daemon and done here ");
//        t1.interrupt();
//        MyThread t1 = new MyThread("radhe");
//        MyThread t2= new MyThread("radhe");
//        MyThread t3 = new MyThread("radhe");
//        t1.setPriority(Thread.MAX_PRIORITY);
//        t2.setPriority(Thread.MIN_PRIORITY);
//        t3.setPriority(Thread.NORM_PRIORITY);
//        t1.start();
//        t2.start();
//        t3.start();
        Thread t = new Thread(new MyThread("THE"));
        t.start();
//        System.out.println("Hello !!");
//        t.join();
//        Thread.sleep(1000);
//        System.out.println("T state : "+t.getState());
//        System.out.println("Main state : "+Thread.currentThread().getState());
//        System.out.println("World ~~");

    }
}
