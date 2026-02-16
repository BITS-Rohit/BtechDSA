package rohit.Thread.Practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleBank {

    SimpleBank(){}

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        System.out.println();


        Thread withdraw1 = Thread.ofVirtual()
                .name("Thread -W(Type :VR)")
                .start(()->{
                    System.out.println(Thread.currentThread().getName());
                    bank.withdraw(200);
                });
//        Thread.sleep(1);
        Thread deposit1 = Thread.ofVirtual()
                .name("Thread -D(Type :VR)")
                .start(()->{
                    System.out.println(Thread.currentThread().getName());
                    bank.Deposit(300);
                });

        deposit1.join();
        withdraw1.join();

    }
}

class Bank {

    Bank() {
        BALANCE = 0;
    }

    private int BALANCE;
    Logger logger = Logger.getLogger(getClass().getName());
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writer = lock.writeLock();
    private final Condition sufficientBalance = writer.newCondition();  // New condition for balance check

    int getBALANCE() {
        return BALANCE;
    }

    void Deposit(int amount) {
        writer.lock();
        try {
            BALANCE += amount;
            System.out.println("Deposit Successful! Current Balance: " + BALANCE);
            sufficientBalance.signalAll();  // Signal any waiting withdraw threads
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            writer.unlock();
        }
    }

    void withdraw(int amount) {
        writer.lock();
        try {
            while (BALANCE < amount) {
                System.out.println("Insufficient Balance. Waiting for deposit...");
                sufficientBalance.await();  // Wait until sufficient balance is available
            }
            BALANCE -= amount;
            System.out.println("Withdrawal Successful! Current Balance: " + BALANCE);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            Thread.currentThread().interrupt();
        } finally {
            writer.unlock();
        }
    }
}
