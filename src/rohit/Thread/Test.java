package rohit.Thread;

public class Test{

    private static Counter counter;

    public static void main(String[] args) throws InterruptedException {
//        Counter counter = new Counter();
//        Counter cc = new Counter();
//        thread t = new thread(counter);
//        thread t1 = new thread(cc);
////        Thread.yield();
//        t.start();
////        t.setPriority(Thread.MAX_PRIORITY);
//        t1.start();
//        t.join();
//        t1.join();
//        System.out.println(counter.getcount());
//        System.out.println(cc.getcount());
//        System.out.println("Test Thread is done ");

        BankAccount b = new BankAccount();
        Runnable run= () -> b.withdraw(50);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
//        Thread t3 = new Thread(run);

        t1.start();
        t2.start();
//        t3.start();
    }
}
