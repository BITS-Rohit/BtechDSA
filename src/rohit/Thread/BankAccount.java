package rohit.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;


public class BankAccount {

    BankAccount(){}
    Logger logger = Logger.getLogger(getClass().getName());
    public void doSomething() {
    logger.info("A cute error -> Error chan came here ; hehe");  // Compliant, output via logger
    }
    private int BALANCE=100;
    private final String name =Thread.currentThread().getName();
    private final String mess=name+" is attempting to withdraw ";
    synchronized void withdraw(int amount ){
        logger.info(mess+amount);
        if (BALANCE>=amount){
            logger.info(name+" is in process of withdrawl..");
            BALANCE-=amount;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name+" is done.");
        }
        else System.out.println(name+" is trying hard but insufficient Balance");
    }

    private final Lock lock = new ReentrantLock();

    void WithDrawnew(int amount) {
        logger.info(mess+amount);

        // Use lock.lock() to wait until the lock is available
        lock.lock();
        try {
            if (BALANCE >= amount) {
                logger.info(name + " is in process of withdrawal...");
                BALANCE -= amount;

                // Simulate the delay during withdrawal
                Thread.sleep(2000);

                logger.info(name + " is done.");
            }
            else {
                logger.info(name + " is trying hard but insufficient Balance.");
            }
        }
        catch (InterruptedException e) {
            doSomething();
            Thread.currentThread().interrupt();
        }
        finally {
            lock.unlock();  // Always release the lock
        }
    }

    void draw(int amount){
        logger.info(mess+amount);

        try{
            if (lock.tryLock()){        //1000, TimeUnit.MILLISECONDS
                if (BALANCE>=amount){
                    try {
                        logger.info(name + " is in process of withdrawal...");
                        Thread.sleep(100);
                        BALANCE -= amount;
                        logger.info(name + " is done.");
                    } catch (InterruptedException e) {
                        doSomething();
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                }
                else logger.info(name+" insufficent amount ");
            }
            else System.out.println(name+" did not get the lock , will try again ..");
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}

